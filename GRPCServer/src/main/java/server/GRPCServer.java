package server;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.UserService;

public class GRPCServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
								.forPort(9090)
								.addService(new UserService())
								.build();
		
		server.start();
		
		System.out.println("Server is running on following port : "+server.getPort());
	
		System.out.println("Server will stop after 5 minutes");

		server.awaitTermination(300, TimeUnit.SECONDS);
		
		System.out.println("Server stopped...!!!!");
	}

}
