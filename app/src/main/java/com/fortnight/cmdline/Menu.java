package com.fortnight.cmdline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
	private String message;
	private ArrayList<Option> options;
	private BufferedReader br;
	
	public Menu(String message) {
		this.message=message;
		this.options = new ArrayList<Option>();
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addOption(String description) {
		int index=options.size()+1;
		Option option = new Option(index,description);
		options.add(option);
	}
	
	public int run() throws IOException {
    	int selectedOption=0;
    	while(selectedOption<1 || selectedOption>options.size()) {
			for(Option option: options) {
				System.out.println(option.getIndex()+") "+option.getDescription());
			}
			try {
				selectedOption = Integer.parseInt(br.readLine());
				if(selectedOption<1 || selectedOption>options.size()) {
					System.out.println("Please select only between specified options");
					selectedOption=0;
				}
			}catch(NumberFormatException nfe) {
				selectedOption=0;
				System.out.println("Please select only between specified options");
			}catch(IOException ioe) {
				selectedOption=0;
				System.err.println("Error while reading input Message:"+ioe.getMessage());
				br.close();
				throw ioe;
			}
    	}
    	return selectedOption;
	}

}
