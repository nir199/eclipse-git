package tomcatwork;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	private InputStream input;
	private String uri;
	public Request(InputStream input){
		this.input = input;
	}
	public void parse(){
		StringBuilder request = new StringBuilder(2048);
		int i;
		byte[] builder = new byte[2048];
		try {
			i = input.read(builder);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for(int j = 0; j < i; j++){
			request.append((char)builder[j]);
		}
		System.out.print(request.toString());
		uri = parseUri(request.toString());
	}
	public String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1 + 1);
			if(index2 > index1){
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}
	public String getUri(){
		return uri;
	}
}
