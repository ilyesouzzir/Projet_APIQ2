--------------------------------------------------------
--  Fichier créé - dimanche-juin-02-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence APICLASSEMENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ORA49"."APICLASSEMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence APICOURSE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ORA49"."APICOURSE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 221 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence APIPAYS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ORA49"."APIPAYS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence APIPILOTE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ORA49"."APIPILOTE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence APIVILLE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ORA49"."APIVILLE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table APICLASSEMENT
--------------------------------------------------------

  CREATE TABLE "ORA49"."APICLASSEMENT" 
   (	"IDCOURSE" NUMBER(*,0), 
	"IDPILOTE" NUMBER(*,0), 
	"IDCLASSEMENT" NUMBER(*,0), 
	"PLACE" NUMBER(*,0), 
	"GAIN" NUMBER(15,2)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table APICOURSE
--------------------------------------------------------

  CREATE TABLE "ORA49"."APICOURSE" 
   (	"IDCOURSE" NUMBER(*,0), 
	"NOM" VARCHAR2(50 BYTE), 
	"PRICEMONEY" NUMBER(10,2), 
	"DATECOURSE" DATE, 
	"KM" NUMBER(*,0), 
	"IDVILLE" NUMBER(38,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table APIPAYS
--------------------------------------------------------

  CREATE TABLE "ORA49"."APIPAYS" 
   (	"IDPAYS" NUMBER(*,0) DEFAULT NULL, 
	"SIGLE" VARCHAR2(50 BYTE), 
	"NOM" VARCHAR2(50 BYTE), 
	"LANGUE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table APIPILOTE
--------------------------------------------------------

  CREATE TABLE "ORA49"."APIPILOTE" 
   (	"IDPILOTE" NUMBER(*,0), 
	"MATRICULE" VARCHAR2(50 BYTE), 
	"NOM" VARCHAR2(50 BYTE), 
	"PRENOM" VARCHAR2(50 BYTE), 
	"DATENAISS" DATE, 
	"IDPAYS" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table APIVILLE
--------------------------------------------------------

  CREATE TABLE "ORA49"."APIVILLE" 
   (	"IDVILLE" NUMBER(*,0), 
	"NOM" VARCHAR2(50 BYTE), 
	"LATITUDE" NUMBER, 
	"LONGITUDE" NUMBER, 
	"IDPAYS" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for View APICLIENTCOMFACT
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APICLIENTCOMFACT" ("IDCLIENT", "NOM", "PRENOM", "CP", "LOCALITE", "RUE", "NUM", "TEL", "IDCOMMANDE", "NUMFACT", "MONTANT", "ETAT", "DATECOMMANDE", "DATEFACTURATION", "DATEPAYEMENT") AS 
  SELECT 
 apiclient.idclient as idclient,
 apiclient.nom as nom,
 apiclient.prenom as prenom,
 apiclient.cp as cp,
 apiclient.localite as localite,
 apiclient.rue as rue,
 apiclient.num as num,
 apiclient.tel as tel,
 apicomfact.idcommande as idcommande,
 apicomfact.numfact as numfact,
 apicomfact.montant as montant,
 apicomfact.etat as etat,
 apicomfact.datecommande as datecommande,
 apicomfact.datefacturation as datefacturation,
 apicomfact.datepayement as datepayement
FROM 
apiclient join apicomfact on apiclient.idclient = apicomfact.idclient
order by apiclient.idclient
;
--------------------------------------------------------
--  DDL for View APICLIENTCOMFACTV2
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APICLIENTCOMFACTV2" ("IDCLIENT", "NOM", "PRENOM", "CP", "LOCALITE", "RUE", "NUM", "TEL", "IDCOMMANDE", "NUMFACT", "MONTANT", "ETAT", "DATECOMMANDE", "DATEFACTURATION", "DATEPAYEMENT") AS 
  SELECT 
 apiclient.idclient as idclient,
 apiclient.nom as nom,
 apiclient.prenom as prenom,
 apiclient.cp as cp,
 apiclient.localite as localite,
 apiclient.rue as rue,
 apiclient.num as num,
 apiclient.tel as tel,
 apicomfact.idcommande as idcommande,
 apicomfact.numfact as numfact,
 apicomfact.montant as montant,
 apicomfact.etat as etat,
 apicomfact.datecommande as datecommande,
 apicomfact.datefacturation as datefacturation,
 apicomfact.datepayement as datepayement
FROM 
apiclient left join apicomfact on apiclient.idclient = apicomfact.idclient
order by apiclient.idclient
;
--------------------------------------------------------
--  DDL for View APICLIFACT
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APICLIFACT" ("NOM", "PRENOM", "IDCLIENT", "NUMCOMMANDE", "ETAT", "MONTANT") AS 
  select APICLIENT.NOM as NOM,
APICLIENT.PRENOM as PRENOM,
APICLIENT.IDCLIENT as IDCLIENT,
APICOMFACT.IDCOMMANDE as IDCOMMANDE,
APICOMFACT.ETAT as ETAT,
APICOMFACT.MONTANT as MONTANT
from APICOMFACT APICOMFACT inner join 
APICLIENT APICLIENT
on APICOMFACT.IDCLIENT =APICLIENT.IDCLIENT
order by APICLIENT.NOM ASC, APICLIENT.PRENOM ASC
;
--------------------------------------------------------
--  DDL for View APICLISMONS
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APICLISMONS" ("NOM", "PRENOM", "LOCALITE") AS 
  SELECT 
    nom,prenom,localite 
FROM 
    apiclient
where cp=7000
;
--------------------------------------------------------
--  DDL for View APICOMFACTCLIENTPROD
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APICOMFACTCLIENTPROD" ("IDCOMMANDE", "NUMFACT", "MONTANT", "ETAT", "DATECOMMANDE", "DATEFACTURATION", "DATEPAYEMENT", "IDCLIENT", "NOM", "PRENOM", "CP", "LOCALITE", "RUE", "NUM", "TEL", "IDPRODUIT", "NUMPROD", "DESCRIPTION", "QUANTITE", "PRIXACHAT") AS 
  SELECT 
  apicomfact.idcommande as idcommande,
 apicomfact.numfact as numfact,
 apicomfact.montant as montant,
 apicomfact.etat as etat,
 apicomfact.datecommande as datecommande,
 apicomfact.datefacturation as datefacturation,
 apicomfact.datepayement as datepayement,
 apiclient.idclient as idclient,
 apiclient.nom as nom,
 apiclient.prenom as prenom,
 apiclient.cp as cp,
 apiclient.localite as localite,
 apiclient.rue as rue,
 apiclient.num as num,
 apiclient.tel as tel,
 apiproduit.idproduit as idproduit,
 apiproduit.numprod as numprod,
 apiproduit.description as description,
 apiligne.quantite as quantite,
 apiligne.prixachat as prixachat
 
FROM 
apicomfact join apiclient on apicomfact.idclient = apiclient.idclient left join apiligne on apicomfact.idcommande=apiligne.idcommande left join apiproduit on apiligne.idproduit=apiproduit.idproduit
order by apicomfact.idcommande
;
--------------------------------------------------------
--  DDL for View APILIGNESCOM
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APILIGNESCOM" ("IDCOMMANDE", "DATECOMMANDE", "QUANTITE", "PRIXACHAT") AS 
  select    APICOMFACT.IDCOMMANDE as IDCOMMANDE,
APICOMFACT.DATECOMMANDE as DATECOMMANDE,
APILIGNE.QUANTITE as QUANTITE,
APILIGNE.PRIXACHAT as PRIXACHAT
from APILIGNE INNER JOIN APICOMFACT
ON  APICOMFACT.IDCOMMANDE=APILIGNE.IDCOMMANDE
order by APICOMFACT.IDCOMMANDE
;
--------------------------------------------------------
--  DDL for View APITOTCOM
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."APITOTCOM" ("IDCOMMANDE", "DATECOMMANDE", "TOTAL") AS 
  select
APICOMFACT.IDCOMMANDE as IDCOMMANDE,
APICOMFACT.DATECOMMANDE as DATECOMMANDE, 
sum(APILIGNE.QUANTITE * APILIGNE.PRIXACHAT) as TOTAL
 from	 APILIGNE INNER JOIN APICOMFACT 
 ON APICOMFACT.IDCOMMANDE=APILIGNE.IDCOMMANDE group by APICOMFACT.IDCOMMANDE,APICOMFACT.DATECOMMANDE
;
--------------------------------------------------------
--  DDL for View AUTORISEEMPLOYÉ
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."AUTORISEEMPLOYÉ" ("PRENOM", "NOM", "DEPARTEMENT") AS 
  select e.first_name AS prenom , e.last_name AS NOM , d.department_id AS Departement
from HR.employees e
join HR.Departments d on e.department_id = d.department_id
;
--------------------------------------------------------
--  DDL for View DEPT20
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."DEPT20" ("EMPNO", "EMPLOYEE", "DEPTNO") AS 
  SELECT EMPLOYEE_ID AS EMPNO, 
       FIRST_NAME || ' ' || LAST_NAME AS EMPLOYEE, 
       DEPARTMENT_ID AS DEPTNO
FROM EMPLOYE
WHERE DEPARTMENT_ID = 20
WITH CHECK OPTION CONSTRAINT "DEPT20_CK"
;
--------------------------------------------------------
--  DDL for View EMP_VU
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."EMP_VU" ("EMPLOYEE_NUMERO", "EMPLOYEE_NOM", "NUMERO_DEPARTEMENT") AS 
  SELECT 
    EMPLOYEE_ID AS EMPLOYEE_NUMERO,
    last_name AS EMPLOYEE_NOM,
    DEPARTMENT_ID AS NUMERO_DEPARTEMENT
FROM 
    EMPLOYE
;
--------------------------------------------------------
--  DDL for View FACTURE
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."FACTURE" ("NUMEROCOMMANDE", "NUMEROCLIENT", "NOMCLIENT", "DATECOMMANDE", "PRIXTOTAL") AS 
  SELECT
    C.NCOM AS NumeroCommande,
    C.NCLI AS NumeroClient,
    Cl.NOM AS NomClient,
    C.DATECOM AS DateCommande,
    SUM(P.PRIX * D.QCOM) AS PrixTotal
FROM
    COMMANDE C
    JOIN CLIENT Cl ON C.NCLI = Cl.NCLI
    JOIN DETAIL D ON C.NCOM = D.NCOM
    JOIN PRODUIT P ON D.NPRO = P.NPRO 
GROUP BY
    C.NCOM, C.NCLI, Cl.NOM, C.DATECOM
;
--------------------------------------------------------
--  DDL for View PILOTESINVILLE
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."PILOTESINVILLE" ("idpilote", "matricule", "nom", "prenom", "datenaiss", "ville_nom") AS 
  SELECT
        pilote.IDPILOTE,
        pilote.MATRICULE,
        pilote.NOM,
        pilote.PRENOM,
        pilote.DATENAISS,
        ville.NOM AS ville_nom
    FROM
        APIPILOTE pilote
    JOIN
        APIPAYS pays ON pilote.IDPAYS = pays.IDPAYS
    JOIN
        APIVILLE ville ON pays.IDPAYS = ville.IDPAYS
    ORDER BY
        ville.NOM
;
--------------------------------------------------------
--  DDL for View PilotesInVille
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."PilotesInVille" ("idpilote", "matricule", "nom", "prenom", "datenaiss", "ville_nom") AS 
  SELECT
        pilote.IDPILOTE,
        pilote.MATRICULE,
        pilote.NOM,
        pilote.PRENOM,
        pilote.DATENAISS,
        ville.NOM AS ville_nom
    FROM
        APIPILOTE pilote
    JOIN
        APIPAYS pays ON pilote.IDPAYS = pays.IDPAYS
    JOIN
        APIVILLE ville ON pays.IDPAYS = ville.IDPAYS
    ORDER BY
        ville.NOM
;
--------------------------------------------------------
--  DDL for View PRODCLI
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."PRODCLI" ("IDCLIENT", "IDPRODUIT", "NUMPROD", "DESCRIPTION") AS 
  SELECT 
    distinct apiclient.idclient as idclient, apiproduit.idproduit as idproduit,apiproduit.numprod as numprod,apiproduit.description as description 
FROM   
apiclient inner join apicomfact on apiclient.idclient=apicomfact.idclient inner join apiligne on apicomfact.idcommande=apiligne.idcommande inner join apiproduit on apiligne.idproduit=apiproduit.idproduit
;
--------------------------------------------------------
--  DDL for View V_DETAIL
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."V_DETAIL" ("NCOM", "NPRO", "LIBELLE", "PRIX", "QCOM") AS 
  SELECT
  D.ncom,
  D.npro,
  P.LIBELLE,
  P.PRIX,
  D.qcom
FROM
  Detail D
JOIN
  Produit P ON D.npro = P.npro
;
--------------------------------------------------------
--  DDL for View VUECLIENT
--------------------------------------------------------

  CREATE OR REPLACE FORCE EDITIONABLE VIEW "ORA49"."VUECLIENT" ("NCLI", "NOM", "LOCALITE") AS 
  select ncli,nom,localite
from client 
where cat='C1'
;
REM INSERTING into ORA49.APICLASSEMENT
SET DEFINE OFF;
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('1','61','1','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('1','62','22','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('1','21','2','1','1000');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('1','1','3','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('1','2','4','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('2','1','5','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('2','3','6','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('3','2','7','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('3','3','8','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('4','2','9','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('4','1','10','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('5','3','11','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('5','1','12','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('6','3','13','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('6','2','14','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('7','2','15','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('7','1','16','2','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('8','1','17','1','100');
Insert into ORA49.APICLASSEMENT (IDCOURSE,IDPILOTE,IDCLASSEMENT,PLACE,GAIN) values ('8','3','18','2','100');
REM INSERTING into ORA49.APICOURSE
SET DEFINE OFF;
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('165','projet','965',to_date('25/10/24','DD/MM/RR'),'258','1');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('189','SAO PAULO','1204',to_date('17/11/24','DD/MM/RR'),'12','3');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('201','Bray','148',to_date('31/05/24','DD/MM/RR'),'15','4');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('143','Binche','4500',to_date('25/12/24','DD/MM/RR'),'15','2');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('1','Grand Prix de France','1500',to_date('01/05/24','DD/MM/RR'),'50','2');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('2','Circuit de Paris','2000',to_date('15/06/24','DD/MM/RR'),'75','1');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('3','Gran Premio d''Italia','1800',to_date('10/05/24','DD/MM/RR'),'60','3');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('4','Circuito di Roma','2200',to_date('25/06/24','DD/MM/RR'),'80','4');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('5','British Grand Prix','1700',to_date('20/05/24','DD/MM/RR'),'55','5');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('6','Silverstone Circuit','100',to_date('05/07/24','DD/MM/RR'),'2150','5');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('7','Deutscher Grand Prix','1600',to_date('30/05/24','DD/MM/RR'),'45','7');
Insert into ORA49.APICOURSE (IDCOURSE,NOM,PRICEMONEY,DATECOURSE,KM,IDVILLE) values ('8','Nürburgring Circuit','2000',to_date('15/07/24','DD/MM/RR'),'90','8');
REM INSERTING into ORA49.APIPAYS
SET DEFINE OFF;
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('6','BE','Belgique','BE');
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('1','FR','France','Français');
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('2','IT','Italie','Italien');
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('3','UK','Royaume-Uni','Anglais');
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('4','DE','Allemagne','Allemand');
Insert into ORA49.APIPAYS (IDPAYS,SIGLE,NOM,LANGUE) values ('5','MC','Monaco','Français');
REM INSERTING into ORA49.APIPILOTE
SET DEFINE OFF;
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('21','PIL001','Ouzzir','Ilyes',to_date('25/02/04','DD/MM/RR'),'3');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('45','PIL45','Lamouche','Pascal',to_date('01/01/90','DD/MM/RR'),'1');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('61','PILOTE1','Jean','Dupond',to_date('25/02/04','DD/MM/RR'),'1');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('62','PILOTE2','Ouzzir','Billal',to_date('25/02/99','DD/MM/RR'),'2');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('1','ABC123','Dupont','Jean',to_date('01/01/90','DD/MM/RR'),'1');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('2','DEF456','Dubois','Pierre',to_date('15/03/92','DD/MM/RR'),'2');
Insert into ORA49.APIPILOTE (IDPILOTE,MATRICULE,NOM,PRENOM,DATENAISS,IDPAYS) values ('3','GHI789','Durant','Jacques',to_date('20/07/88','DD/MM/RR'),'3');
REM INSERTING into ORA49.APIVILLE
SET DEFINE OFF;
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('1','Monaco','43,7384','7,4346','5');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('2','Le Mans','48','0,2','1');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('3','Monza','45,5833','9,2667','2');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('4','Mugello','43,9833','11,3333','2');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('5','Silverstone','52,0786','-1,0169','3');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('6','Donington Park','52,8348','-1,3792','3');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('7','Hockenheim','49,3278','8,5658','4');
Insert into ORA49.APIVILLE (IDVILLE,NOM,LATITUDE,LONGITUDE,IDPAYS) values ('8','Nürburgring','50,3358','6,9475','4');
--------------------------------------------------------
--  DDL for Trigger APICLASSEMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APICLASSEMENT_TRG" 
BEFORE INSERT ON APICLASSEMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDCOURSE IS NULL THEN
      SELECT APICLASSEMENT_SEQ.NEXTVAL INTO :NEW.IDCOURSE FROM SYS.DUAL;
    END IF;
    IF INSERTING AND :NEW.IDCLASSEMENT IS NULL THEN
      SELECT APICLASSEMENT_SEQ.NEXTVAL INTO :NEW.IDCLASSEMENT FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APICLASSEMENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APICOURSE_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APICOURSE_TRG" 
BEFORE INSERT ON APICOURSE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDCOURSE IS NULL THEN
      SELECT APICOURSE_SEQ.NEXTVAL INTO :NEW.IDCOURSE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APICOURSE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APIPAYS_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APIPAYS_TRG" 
BEFORE INSERT ON APIPAYS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDPAYS IS NULL THEN
      SELECT APIPAYS_SEQ.NEXTVAL INTO :NEW.IDPAYS FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APIPAYS_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APIPILOTE_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APIPILOTE_TRG" 
BEFORE INSERT ON APIPILOTE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDPILOTE IS NULL THEN
      SELECT APIPILOTE_SEQ.NEXTVAL INTO :NEW.IDPILOTE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APIPILOTE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APIVILLE_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APIVILLE_TRG" 
BEFORE INSERT ON APIVILLE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDVILLE IS NULL THEN
      SELECT APIVILLE_SEQ.NEXTVAL INTO :NEW.IDVILLE FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APIVILLE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APIPAYS_TRG1
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APIPAYS_TRG1" 
BEFORE INSERT ON APIPAYS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APIPAYS_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger APIVILLE_TRG1
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "ORA49"."APIVILLE_TRG1" 
BEFORE INSERT ON APIVILLE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ORA49"."APIVILLE_TRG1" ENABLE;
--------------------------------------------------------
--  Constraints for Table APICLASSEMENT
--------------------------------------------------------

  ALTER TABLE "ORA49"."APICLASSEMENT" MODIFY ("IDCLASSEMENT" NOT NULL ENABLE);
  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "unique_fk_course_pilote" UNIQUE ("IDCOURSE", "IDPILOTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "CHECK_PLACE" CHECK (place >0 or place =-1) ENABLE;
  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "CHECK_GAIN" CHECK (gain >= 0) ENABLE;
  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "APICLASSEMENT_PK" PRIMARY KEY ("IDCLASSEMENT")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table APICOURSE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APICOURSE" MODIFY ("DATECOURSE" NOT NULL ENABLE);
  ALTER TABLE "ORA49"."APICOURSE" MODIFY ("KM" NOT NULL ENABLE);
  ALTER TABLE "ORA49"."APICOURSE" ADD CONSTRAINT "PK_COURSE" PRIMARY KEY ("IDCOURSE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APICOURSE" ADD CONSTRAINT "UC_NOM" UNIQUE ("NOM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APICOURSE" ADD CONSTRAINT "CHECK_PRICEMONEY" CHECK (priceMoney >= 0) ENABLE;
  ALTER TABLE "ORA49"."APICOURSE" ADD CONSTRAINT "CHECK_KM" CHECK (km > 0) ENABLE;
--------------------------------------------------------
--  Constraints for Table APIPAYS
--------------------------------------------------------

  ALTER TABLE "ORA49"."APIPAYS" ADD CONSTRAINT "PK_PAYS" PRIMARY KEY ("IDPAYS")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APIPAYS" ADD CONSTRAINT "UNIQUE_SIGLE" UNIQUE ("SIGLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APIPAYS" MODIFY ("IDPAYS" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table APIPILOTE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APIPILOTE" ADD CONSTRAINT "PK_PILOTE" PRIMARY KEY ("IDPILOTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APIPILOTE" ADD CONSTRAINT "UNIQUE_MATRICULE" UNIQUE ("MATRICULE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APIPILOTE" MODIFY ("NOM" NOT NULL ENABLE);
  ALTER TABLE "ORA49"."APIPILOTE" MODIFY ("PRENOM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table APIVILLE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APIVILLE" ADD CONSTRAINT "PK_VILLE" PRIMARY KEY ("IDVILLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA49"."APIVILLE" ADD CONSTRAINT "UNIQUE_COORDONNES" UNIQUE ("LATITUDE", "LONGITUDE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APICLASSEMENT
--------------------------------------------------------

  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "fk_course" FOREIGN KEY ("IDCOURSE")
	  REFERENCES "ORA49"."APICOURSE" ("IDCOURSE") ENABLE;
  ALTER TABLE "ORA49"."APICLASSEMENT" ADD CONSTRAINT "fk_pilote" FOREIGN KEY ("IDPILOTE")
	  REFERENCES "ORA49"."APIPILOTE" ("IDPILOTE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APICOURSE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APICOURSE" ADD CONSTRAINT "FK_IDVILLE" FOREIGN KEY ("IDVILLE")
	  REFERENCES "ORA49"."APIVILLE" ("IDVILLE") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APIPILOTE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APIPILOTE" ADD CONSTRAINT "FK_PAYS" FOREIGN KEY ("IDPAYS")
	  REFERENCES "ORA49"."APIPAYS" ("IDPAYS") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table APIVILLE
--------------------------------------------------------

  ALTER TABLE "ORA49"."APIVILLE" ADD CONSTRAINT "FKPAYS_PAYS" FOREIGN KEY ("IDPAYS")
	  REFERENCES "ORA49"."APIPAYS" ("IDPAYS") ENABLE;
