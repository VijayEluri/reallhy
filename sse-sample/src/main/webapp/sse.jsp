<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>EventSource example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="./js/EventSource.js"></script>
    <script>
        var eventSource = new EventSource("hello-sse");
        eventSource.addEventListener('up_vote', function(event) {
            document.getElementById('up').innerHTML = event.data;
        }, false);

        eventSource.addEventListener('down_vote', function(event) {
               document.getElementById('down').innerHTML = event.data;
        }, false);
    </script>
</head>
<body>
Up vote: <span id="up"></span> Down vote: <span id="down"></span>
</body>
</html>