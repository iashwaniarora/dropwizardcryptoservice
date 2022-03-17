# dropwizardcryptoservice
How to run :-
1. Start the server
a.	Go to directory where the jar has been extracted or compiled .
b.	Run command 
c.	java -jar dropwizardcryptoservice-1.0-SNAPSHOT.jar server config.yml
d.	This will start the server on port 9000 and the admin configuration on 9001.
i.	If the ports are already being used please use other ports
ii.	If you decide to change the port all the API requests should be changed to use the new port.
<br>
2. Use Curl command to query the server. Alternatively, I have attached the postman scripts as well. Those can be imported in the postman and can be used directly.

<br>
3. Sample Input and Output.
a.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=4
b.	{"average":4.0,"standardDeviation":0.0}
c.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=7 
d.	{"average":5.5,"standardDeviation":1.5}
e.	curl --location --request GET http://localhost:9000/crypto/pushandrelocate?number=6 
f.	{"average":5.667,"standardDeviation":1.247}
g.	curl --location --request GET http://localhost:9000/crypto/pushrecalculateandencrypt?number=9 
h.	{"average":"dB5uFCwWyBB9Eywoe2Qrdw==","standardDeviation":"N0i3TMy/RHqOzSboUxaQLw=="}
i.	curl --location --request GET http://localhost:9000/crypto/decrypt?encryptedText=dB5uFCwWyBB9Eywoe2Qrdw== 
j.	{"number":6.5}
k.	curl --location --request GET http://localhost:9000/crypto/decrypt?encryptedText=N0i3TMy/RHqOzSboUxaQLw== 
l.	{"number":1.803}

