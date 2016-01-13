var cp = require("child_process");
cp.exec("dir /", function (error, stdout, stderr){
	console.log('stdout :'+stdout)
	console.log('stderr :'+stderr)
	if(error != null){
		console.log('exec error: '+error)
	}
});