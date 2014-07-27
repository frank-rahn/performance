/*
 * Copyright © 2014 by Frank W. Rahn. Alle Rechte vorbehalten. All rights
 * reserved.
 */
package de.rahn.performance.beanmapper.utils;

import static org.apache.commons.lang.ArrayUtils.contains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.rahn.performance.beanmapper.TestBeansMapperBean;

/**
 * Dieser Manager kennt alle implementierten {@link TestBeansMapperBean}s.
 * @author Frank W. Rahn
 */
@Component
public class MapperManager {

	@Autowired
	private TestBeansMapperBean[] mappers;

	private Map<String, TestBeansMapperBean> mapperByName;

	private String[] names;

	@PostConstruct
	public void initialize() {
		mapperByName = new HashMap<String, TestBeansMapperBean>(mappers.length);
		names = new String[mappers.length];

		for (int i = 0; i < mappers.length; i++) {
			names[i] = mappers[i].getMapperName();
			mapperByName.put(mappers[i].getMapperName(), mappers[i]);
		}
	}

	/**
	 * @return alle existierenden Mappers
	 */
	public TestBeansMapperBean[] getMappers() {
		return mappers;
	}

	/**
	 * @param excluded die auszulassenden Mapper
	 * @return die existierenden Mappers ohne die angegebenen Mapper
	 */
	public TestBeansMapperBean[] getMappersExcluded(String[] excluded) {
		List<TestBeansMapperBean> result = new ArrayList<TestBeansMapperBean>();

		for (Entry<String, TestBeansMapperBean> entry : mapperByName.entrySet()) {
			if (!contains(excluded, entry.getKey())) {
				result.add(entry.getValue());
			}
		}
		return result.toArray(new TestBeansMapperBean[result.size()]);
	}

	/**
	 * @param der Names des gewünschten Mappers
	 * @return der Mapper zum Namen
	 */
	public TestBeansMapperBean getMapper(String name) {
		return mapperByName.get(name);
	}

	/**
	 * @return die Liste der Namen der Mappers
	 */
	public String[] getNames() {
		return names;
	}

}