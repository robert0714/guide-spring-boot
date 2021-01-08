package hello;

import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	 

	@RequestMapping("/hello")
	public String hello() {
		String des ="";
		try {
			 
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("google.com", 80));
			des =socket.getLocalAddress()!=null ?socket.getLocalAddress().toString() : "" ;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Greetings from Spring Boot! "+des;
	}

}
