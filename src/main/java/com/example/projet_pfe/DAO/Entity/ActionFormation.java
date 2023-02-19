package com.example.projet_pfe.DAO.Entity;


    import java.sql.*;

public class ActionFormation {
        private static final String URL = "jdbc:postgresql://localhost:5432/Blida";
        private static final String USER = "Blida";
        private static final String PASSWORD = "0553364552";

        public static void main(String[] args) {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                // Execute each SQL statement one by one
                stmt.execute("CREATE TABLE ACTION_FORMATION (CODE_ACT NUMBER(3) NOT NULL, CODE_BR NUMBER(2) NOT NULL, LIB_FORM VARCHAR2(150 BYTE) NOT NULL, CODE_ACT_I VARCHAR2(10 BYTE), DUREE NUMBER(2), BUT_FORM VARCHAR2(100 BYTE), COULEUR VARCHAR2(15 BYTE), TYPE_HORAIRE CHAR(3 BYTE) DEFAULT 'FPS' NOT NULL, GSP CHAR(3 BYTE), CODE_FICHE CHAR(8 BYTE)) TABLESPACE USERS PCTUSED 0 PCTFREE 10 INITRANS 1 MAXTRANS 255 STORAGE (INITIAL 64K MINEXTENTS 1 MAXEXTENTS 2147483645 PCTINCREASE 0 BUFFER_POOL DEFAULT) LOGGING NOCACHE NOPARALLEL NOMONITORING;");
                stmt.execute("CREATE INDEX ACTION_FORMATION_FK1 ON ACTION_FORMATION (CODE_BR) LOGGING TABLESPACE USERS PCTFREE 10 INITRANS 2 MAXTRANS 255 STORAGE (INITIAL 64K MINEXTENTS 1 MAXEXTENTS 2147483645 PCTINCREASE 0 BUFFER_POOL DEFAULT) NOPARALLEL;");
                stmt.execute("CREATE UNIQUE INDEX PK_ACTION_FORMATION ON ACTION_FORMATION (CODE_ACT) LOGGING TABLESPACE USERS PCTFREE 10 INITRANS 2 MAXTRANS 255 STORAGE (INITIAL 64K MINEXTENTS 1 MAXEXTENTS 2147483645 PCTINCREASE 0 BUFFER_POOL DEFAULT) NOPARALLEL;");
                stmt.execute("CREATE UNIQUE INDEX INDEX_NOM_FORM ON ACTION_FORMATION (LIB_FORM) LOGGING TABLESPACE USERS PCTFREE 10 INITRANS 2 MAXTRANS 255 STORAGE (INITIAL 64K MINEXTENTS 1 MAXEXTENTS 2147483645 PCTINCREASE 0 BUFFER_POOL DEFAULT) NOPARALLEL;");
                stmt.execute("CREATE OR REPLACE TRIGGER insert_act_form before insert ON ACTION_FORMATION for each row declare begin :new.code_act:=omar.get_code_action; end;");
                stmt.execute("ALTER TABLE ACTION_FORMATION ADD (CONSTRAINT PK_ACTION_FORMATION PRIMARY KEY (CODE_ACT) USING INDEX TABLESPACE USERS PCTFREE 10 INITRANS 2 MAXTRANS 255 STORAGE (INITIAL 64K MINEXTENTS 1 MAXEXTENTS 2147483645 PCTINCREASE 0));");
                stmt.execute("ALTER TABLE ACTION_FORMATION ADD (CONSTRAINT FK_BRANCHE FOREIGN KEY (CODE_BR) REFERENCES BRANCHE (CODE_BR));");
                stmt.execute("GRANT SELECT ON ACTION_FORMATION TO AGENT_FACTURATION;");
                stmt.execute("GRANT SELECT ON ACTION_FORMATION TO BILAN WITH GRANT OPTION;");
                stmt.execute("GRANT SELECT ON ACTION_FORMATION TO CHEF_STRUCT_COMM;");
                stmt.execute("GRANT ALTER, DELETE, INDEX, INSERT, REFERENCES, SELECT, UPDATE ON ACTION_FORMATION TO FACT WITH GRANT OPTION;");


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }    }