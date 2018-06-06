
ambit2-haas : The Ambit REST wrapper for It4I middleware
ambit2-hpcws: WSDL generated classes for It4I services

# HAAS wrapper 

Compile with 

```
cd ambit2-haas
mvn package -P ambit-haas -P excape_hpcws
```

Include these in your maven settings (~/.m2/settings.xml)

```
    <profile>
      <id>excape_hpcws</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <haas.user>yourhaaspwd</haas.user>
        <haas.pwd>yourhaasuser</haas.pwd>
        <haas.knownhosts>d://bin/putty/known_hosts</haas.knownhosts>
        <haas.keyfile>d://bin/putty/salomon_id_rsa.ppk</haas.keyfile>
        <HAAS_HOME>folder_for_tmp_files</HAAS_HOME>
      </properties>
    </profile>   
```


```
  <!-- test-->
    <profile>
      <id>ambit-haas</id>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <properties>
        <custom.search>https://apps.ideaconsult.net/excape</custom.search>
        <custom.title>HaaS prototype</custom.title>
        <custom.description>Local test instance!</custom.description>
        <custom.logo></custom.logo>
        <custom.query></custom.query>
        <custom.structurequery></custom.structurequery>
        <custom.color>#003B9F</custom.color>
        <!--
      	http://localhost:9090/ambit2/proxy
      	<custom.color>#729203</custom.color>
      	-->
        <google.analytics>UA-8771500-6</google.analytics>
        <ambit.db>ambit-test</ambit.db>
        <ambit.db.host>localhost</ambit.db.host>
        <ambit.db.user.root.password></ambit.db.user.root.password>
        <ambit.db.user.test>guest</ambit.db.user.test>
        <ambit.db.user.test.password>guest</ambit.db.user.test.password>
        <rdf.writer>stax</rdf.writer>
        <dataset.members.prefix>false</dataset.members.prefix>
        <ambit.db.create.allow>true</ambit.db.create.allow>
        <service.ontology>http://apps.ideaconsult.net:8080/ontology</service.ontology>
        <OBABEL_HOME>C:/Program Files (x86)/OpenBabel-2.3.2</OBABEL_HOME>
        <aa.enabled>false</aa.enabled>
        <ambit.report.level>debug</ambit.report.level>
        <aa.opensso>http://opensso.in-silico.ch/opensso/identity</aa.opensso>
        <aa.policy>http://opensso.in-silico.ch/Pol/opensso-pol</aa.policy>
        <aa.user>guest</aa.user>
        <aa.pass>guest</aa.pass>
        <aa.admin>false</aa.admin>
        <aa.local.enabled>false</aa.local.enabled>
        <aa.local.admin.name>admin</aa.local.admin.name>
        <aa.local.admin.pass>changeit</aa.local.admin.pass>
        <dataset.members.prefix>false</dataset.members.prefix>
        <attach.depict>true</attach.depict>
        <attach.substance>true</attach.substance>
        <attach.investigation>true</attach.investigation>
        <attach.toxmatch>true</attach.toxmatch>
        <attach.substanceowner>true</attach.substanceowner>
        <license.intextfiles>false</license.intextfiles>
        <jsonp>true</jsonp>
        <allowed.origins>*</allowed.origins>
        <enableEmailVerification>false</enableEmailVerification>
        <users.db>ambit_users</users.db>
        <ambit.profile>excape</ambit.profile>
      </properties>
```      