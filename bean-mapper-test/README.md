# Java Bean Mapper Test
In diesem Projekt werden einige Java Bean Mapper getestet.

Weitere Mapper werden gerne hinzugefügt. Anregungen gerne über

* [Pull Requests bei GitHub](https://github.com/frank-rahn/performance/pulls) oder
* [Kontakt-Formular auf meiner Homepage](http://www.frank-rahn.de/contact/?utm_source=github&utm_medium=readme&utm_campaign=performance&utm_content=bean-mapper-test)

## ByHand
Eine Implementierung eines Mapper von Hand (**hand coded**). Dort wird jedes einzelne Attribut von einem Objekt in ein anderes Objekt, ggf. mit Typkonvertierung, kopiert.

## Commons-BeanUtils
Ein Test mit der Klasse `org.apache.commons.beanutils.BeanUtils` aus dem Projekt [Commons BeanUtils](http://commons.apache.org/proper/commons-beanutils/). Diese Klasse nutzt dabei die [JavaBeans Component API](http://docs.oracle.com/javase/6/docs/technotes/guides/beans/index.html) (**reflection-based**).

## Spring-BeanUtils
Ein Test mit der Klasse `org.springframework.beans.BeanUtils` aus dem Projekt [Spring Framework](http://projects.spring.io/spring-framework/). Diese Klasse nutzt dabei die [JavaBeans Component API](http://docs.oracle.com/javase/6/docs/technotes/guides/beans/index.html) (**reflection-based**).

## Dozer-Mapper
Ein Test mit dem Mapping Framework [Dozer](http://dozer.sf.net/). Dieser Mapper verwendet [Reflection](http://docs.oracle.com/javase/6/docs/technotes/guides/reflection/index.html) zum Mappen der Daten (**reflection-based**).

## Orika-Mapper
Ein Test mit dem Mapping Framework [Orica-Mapper](https://code.google.com/p/orika/). Dieser Mapper verwendet Bytecode Generierung mit [Javassist](http://www.csg.ci.i.u-tokyo.ac.jp/~chiba/javassist/) zur Erzeugung von Mappern.

## MapStruct
Ein Test mit dem Mapping Framework [MapStruct](http://mapstruct.org/). Dieser Mapper verwendet einen [Annotation Processor (APT)](http://docs.oracle.com/javase/6/docs/technotes/guides/apt/index.html) zur Erzeugung (Java-Klassen) von Mappern.

## ModelMapper
Ein noch sehr junges Mapping Framework [ModelMapper](http://modelmapper.org/). Dieser Mapper bietet eine API für spezifische Anwendungsfälle an. Dieser Mapper verwendet Bytecode Generierung mit [cglib](https://github.com/cglib/cglib/wiki) zur Erzeugung von Mappern.

## JMapper Framework
Ein weiteres Mapping Framework [JMapper Framework](http://jmapper-framework.github.io/jmapper-core/) mit sehr guten Performenzeigenschaften. Dieser Mapper verwendet Bytecode Generierung mit [Javassist](http://www.csg.ci.i.u-tokyo.ac.jp/~chiba/javassist/) zur Erzeugung von Mappern.

## Selma
Ein Test mit dem Mapping Framework [Selma](http://www.selma-java.org/). Dieser Mapper verwendet einen [Annotation Processor (APT)](http://docs.oracle.com/javase/6/docs/technotes/guides/apt/index.html) zur Erzeugung (Java-Klassen) von Mappern.

## reMap
Ein Test mit dem Mapping Framework [reMap](https://github.com/remondis-it/remap). Der Schwerpunkt von reMap liegt in der Robustheit und einem minimalen Verwaltungsaufwand für Tests. Dieser Mapper verwendet Bytecode Generierung mit [cglib](https://github.com/cglib/cglib/wiki) zur Erzeugung von Mappern.

# Zugehörige Artikel
[Wer ist der optimale Java Bean Mapper?](https://www.frank-rahn.de/java-bean-mapper/?utm_source=github&utm_medium=readme&utm_campaign=performance&utm_content=bean-mapper-test)

# Homepage des Autors
[Frank W. Rahn](https://www.frank-rahn.de/?utm_source=github&utm_medium=readme&utm_campaign=performance&utm_content=bean-mapper-test)