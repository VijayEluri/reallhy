var http = require("http");

http.createServer(function(req, res){
	res.setHeader("Content-Type", "text/plain");
	res.write("Hello\r\n");
	setTimeout(function(){
		res.write("World\r\n");
		res.end();
	}, 2000);
}).listen(8000);