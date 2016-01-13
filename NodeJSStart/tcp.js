var net = require("net");

var s = net.createServer();
s.addListener("connection", function(c){
	console.log("Connected!!! - "+c.toString());
	c.write("hello!");
	c.destroy();	
});
s.listen(8000);