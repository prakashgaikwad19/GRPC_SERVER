package service;

import io.grpc.stub.StreamObserver;
import stubFiles.Userms.LoginReq;
import stubFiles.Userms.LoginResp;
import stubFiles.usermsGrpc.usermsImplBase;

public class UserService extends usermsImplBase{

	@Override
	public void login(LoginReq request, StreamObserver<LoginResp> responseObserver) {
		System.out.println("------Inside login------");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		System.out.println("Username : "+ username);
		System.out.println("Password : "+ password);
		
		LoginResp.Builder loginResponse = LoginResp.newBuilder();
		
		if(username.endsWith("@gmail.com") && password.length() > 8) {
			System.out.println("username and password are correct...!");
			loginResponse.setResponseMessage("SUCCESS").setResponseCode("200");
		}else {
			System.out.println("username and password are wrong...!");
			loginResponse.setResponseMessage("FAILED").setResponseCode("400");
		}
		
		responseObserver.onNext(loginResponse.build());
		
		responseObserver.onCompleted();
		
	}

}
