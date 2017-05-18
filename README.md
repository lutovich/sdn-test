# sdn-test

Repository contains a test Spring Boot app that uses SDN. App demonstrates a `NullPointerException` during rollback after a failed Cypher query.

App expects a running Neo4j with user `neo4j` and password `test`.

Seen stacktrace:

```
Exception in thread "main" java.lang.NullPointerException
	at org.springframework.data.neo4j.transaction.Neo4jTransactionManager.doRollback(Neo4jTransactionManager.java:275)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(AbstractPlatformTransactionManager.java:853)
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.rollback(AbstractPlatformTransactionManager.java:830)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.completeTransactionAfterThrowing(TransactionAspectSupport.java:522)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:286)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:96)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:656)
	at org.neo4j.services.MovieService$$EnhancerBySpringCGLIB$$b8f1a8e3.findByTitle(<generated>)
	at org.neo4j.SampleMovieApplication.main(SampleMovieApplication.java:30)
```
