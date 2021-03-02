package br.com.testejusta.wrapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.com.testejusta.entity.ConvertionEntity;
import br.com.testejusta.util.LoadProperties;

public class LogicalConvertion {

	LoadProperties loadProperties = new LoadProperties();
	
	public ConvertionEntity getConversion(String unit) throws ScriptException {
		ConvertionEntity entity = new ConvertionEntity();
		
		ScriptEngineManager script = new ScriptEngineManager();
		ScriptEngine eng = script.getEngineByName("JavaScript");
		
		String siglaSi = unit.toString();
		
		List<String> unidades = Arrays.asList("minute", "hour", "day", "degree", "arcminute", "arcsecond", "hectare", "lite", "tonne");
		List<String> valores = Arrays.asList("60", "3600", "84600", "0.0174533", "(3.14159265359/10800)", "(3.14159265359/68400)", "1000", "0.001", "1000");
		List<String> sigla = Arrays.asList("s", "s", "s", "rad", "rad", "rad", "m²", "m³", "kg");

		for (int i = 0; i < unidades.size(); i++) {
			if (unit.contains(unidades.get(i))) {
				unit = unit.replace(unidades.get(i), valores.get(i));
				siglaSi = siglaSi.replace(unidades.get(i), sigla.get(i));
			}
		}
		
		double resultado = (double) eng.eval(unit);

		entity.setUnit_name(siglaSi.toUpperCase());
		entity.setMultiplication_factor(resultado);
		return entity;
	}
	
}
