package kr.or.lx.dms.adaptor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.lx.common.ApiService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("adaptor")
@Slf4j
@Controller
public class AdaptorController {
	
    @Value("${dms.api.url}")
    private String dmsApiUrl;	
    
	@Autowired
	private ApiService<?> apiService;
	
	@GetMapping("/config")
	public String list(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/config";
	}	
	
	@GetMapping("/detail/{adapter_id}")
	public String detail(@PathVariable String adapter_id, ModelMap model) throws Exception{
		
		model.put("adapter_id", adapter_id);		
		return "dms/adaptor/detail";
	}	
	
	@GetMapping("/set")
	public String set(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/set";
	}	
	
	@GetMapping("/operate")
	public String operate(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/operate";
	}	
	
	@GetMapping("/instance")
	public String instance(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/instance";
	}	
	
	@GetMapping("/connectionType")
	public String connectionType(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/connectionType";
	}	
	
	@GetMapping("/type")
	public String type(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/type";
	}	
	
	@GetMapping("/preProcessList")
	public String preProcessList(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/preProcessList";
	}	
	
	@GetMapping("/preProcessAdd")
	public String preProcessAdd(ModelMap model) throws Exception{
		
		
		return "dms/adaptor/preProcessAdd";
	}	
	
	@ResponseBody
	@PostMapping("{apiId}")
	public Object adaptorApi(@RequestBody Map<String, Object> param, ModelMap model) throws Exception{
		
		String url = dmsApiUrl+param.get("url");
		
		ResponseEntity<?> responseEntity = apiService.post(url, param);
		Object object = responseEntity.getBody();
		
		return object;
	}	
}
