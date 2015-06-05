# Bean-Mapper Test
In diesem Projekt werden einige Bean-Mapper getestet.

Weitere Mapper werden gerne hinzugefügt. Anregungen gerne über

* [Pull Requests bei GitHub](https://github.com/frank-rahn/performance/pulls) oder
* [Kontakt-Formular auf meiner Homepage](http://www.frank-rahn.de/contact/)

## ByHand
Eine Implementierung eines Mapper von Hand. Dort wird jedes einzelne Attribut von einem Objekt in ein anderes Objekt, ggf. mit Typkonvertierung, kopiert.

## Commons-BeanUtils
Ein Test mit der Klasse `org.apache.commons.beanutils.BeanUtils` aus dem Projekt [Commons BeanUtils](http://commons.apache.org/proper/commons-beanutils/). Diese Klasse nutzt dabei die [JavaBeans Component API](http://docs.oracle.com/javase/6/docs/technotes/guides/beans/index.html).

## Spring-BeanUtils
Ein Test mit der Klasse `org.springframework.beans.BeanUtils` aus dem Projekt [Spring Framework](http://projects.spring.io/spring-framework/). Diese Klasse nutzt dabei die [JavaBeans Component API](http://docs.oracle.com/javase/6/docs/technotes/guides/beans/index.html).

## Dozer-Mapper
Ein Test mit dem Mapping Framework [Dozer](http://dozer.sf.net/). Dieser Mapper verwendet [Reflection](http://docs.oracle.com/javase/6/docs/technotes/guides/reflection/index.html) zum Mappen der Daten.

## Orika-Mapper
Ein Test mit dem Mapping Framework [Orica-Mapper](https://code.google.com/p/orika/). Dieser Mapper verwendet Byte Code Generierung mit [Javassist](http://www.csg.ci.i.u-tokyo.ac.jp/~chiba/javassist/) zum Erzeugung von Mappern.

## MapStruct
Ein Test mit dem Mapping Framework [MapStruct](http://mapstruct.org/). Dieser Mapper verwendet einen [Annotation Prozessor (APT)](http://docs.oracle.com/javase/6/docs/technotes/guides/apt/index.html) zum Erzeugung (Java-Klassen) von Mappern.

## Homepage des Autors
[Frank W. Rahn](http://www.frank-rahn.de)