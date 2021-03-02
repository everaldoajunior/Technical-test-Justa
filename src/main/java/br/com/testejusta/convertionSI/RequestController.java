package br.com.testejusta.convertionSI;

import java.io.IOException;

import javax.script.ScriptException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.testejusta.entity.ConvertionEntity;
import br.com.testejusta.wrapper.LogicalConvertion;

@RestController
@RequestMapping(value = "units")
public class RequestController {

	LogicalConvertion wrapper = new LogicalConvertion();
	
	@RequestMapping(value = "/si", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ConvertionEntity getConverta(HttpServletResponse response, @RequestParam(value = "units") String units) throws IOException, ScriptException {
	    
	    return this.wrapper.getConversion(units);
	}
	
}
