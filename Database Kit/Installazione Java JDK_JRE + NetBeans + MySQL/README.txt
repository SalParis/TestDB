﻿0) Installare MySQL dalla cartella MySQL web installer
	Durante l'instalazione selezionare:
		a) MySQL Server
		b) MySQL Workbench (Utile per gestire le modifiche nel database)
		b) MySQL Notifier (Start/stop servizio server MySQL, senza dover utilizzare il Workbench quando il db ha una versione stabile)
		c) MySQL Excel (Utile per importare da fogli Excel)
		d) MySQL Connector J
	
	Durante le schermate di impostazione, selezionare
		a) Custom installation
		b) NON SELEZIONARE ”CONNESSIONE SICURA SSL SHA-256”, MA LA ”LEGACY”
			Altrimenti alla connessione con java si dovrebbe configurare una connessione SSL, che di default non e' impostata
	
1) Copiare dal: (le versioni possono cambiare)
	C:\Programmmi(x86)\MySQL\Connector J\mysql-connector-java-8.0.11.jar
	al
	C:\Programmi\Java\jre1.8.0_171\lib\ext\mysql-connector-java-8.0.11.jar


2) Aggiungere le variabili d'ambiente(le versioni possono cambiare):
	JAVA_HOME
	C:\Program Files\Java\jdk1.8.0_171
	
	PATH
	C:\Program Files\Java\jdk1.8.0_171\bin;

	CLASSPATH
	.;C:\Program Files\Java\jre1.8.0_171\lib\ext\mysql-connector-java-8.0.11.jar;.;

3) Importare nelle Libraries del progetto con Add JAR\Folder il connettore:
	C:\Programmi\Java\jre1.8.0_171\lib\ext\mysql-connector-java-8.0.11.jar
