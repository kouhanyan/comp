package com.wenda.comp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wenda.comp.service.CollectionService;

@Controller
@RequestMapping("/comp/dataManage")
public class DateManageCompController {
	private static final String PATH = "comp/";

	@Autowired
	private CollectionService collectionService;

	@RequestMapping("/list")
	public String list() {

		return PATH + "dataManage/recover";
	}

	@RequestMapping("/deal")
	public String deal(Model model, @RequestParam("file") MultipartFile file) {
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
			br.close();
			String str = collectionService.deal(list);
			model.addAttribute("message", str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PATH + "dataManage/recover";

	}

}
