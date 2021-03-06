mix-web
=======
just try out some of my thoughts about web application

technology stack
=======
- front: bootstrap、jquery
- basic framework: springmvc、spring、mybatis
- templating engine: freemark、*velocity*
- security: shiro
- workflow: *jbpm*
- rdbms: mysql
- nosql: mongodb、redis、*hbase*
- cache: memcache
- rpc: dubbo
- jms: rocketmq、rabbitmq
- deploy: maven、jetty、nginx
- open api: oauth、*spring social*
- monitor: druid
- search: *lucene、solr、nutch*

goal
=======
- fine-grained access control
- multiple module architecture
- restful architecture
- research distributed architecture
- sql optimization
- performance tuning
- manipulate business table flexibly and dynamically
- abstract basic non-business entity bean
- cache distributed session, authentication and authorization information

privilege
=======
- support function level and data level privilege control
- support menu, page elements, database row and column, code level privilege control
- support visual configuration, xml configuration, page tags, annotation privilege control
- support coding privilege control and extensions

usage
=======
- build and start mysql database
- configure and start memcache & redis
- start zookeeper
- execute mvn clean -Dmaven.test.skip=true install command under root directory
- execute mvn jetty:run -Djetty.port=<port> command under mix-front directory
