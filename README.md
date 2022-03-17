# dropwizardcryptoservice
* How to run :-
1. Start the server
2. Go to directory where the jar has been extracted or compiled .
3.	Run command 
4.	java -jar dropwizardcryptoservice-1.0-SNAPSHOT.jar server config.yml
5.	This will start the server on port 9000 and the admin configuration on 9001.
6.	If the ports are already being used please use other ports
7.	If you decide to change the port all the API requests should be changed to use the new port.

* Use Curl command to query the server. Alternatively, I have attached the postman scripts as well. Those can be imported in the postman and can be used directly.
<br></br>
* Sample Input and Output.
1.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=4
2.	{"average":4.0,"standardDeviation":0.0}
3.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=7 
4.	{"average":5.5,"standardDeviation":1.5}
5.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=6 
6.	{"average":5.667,"standardDeviation":1.247}
7.	curl --location --request GET http://localhost:9000/crypto/pushrecalculateandencrypt?number=9 
8.	{"average":"dB5uFCwWyBB9Eywoe2Qrdw==","standardDeviation":"N0i3TMy/RHqOzSboUxaQLw=="}
9.	curl --location --request GET http://localhost:9000/crypto/decrypt?encryptedText=dB5uFCwWyBB9Eywoe2Qrdw== 
10.	{"number":6.5}
11.	curl --location --request GET http://localhost:9000/crypto/decrypt?encryptedText=N0i3TMy/RHqOzSboUxaQLw== 
12.	{"number":1.803}

