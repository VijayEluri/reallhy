<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Jquery Polyfill EventSource example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="./js/jquery-1.11.0.min.js"></script>
    <script src="./js/jquery.eventsource.js"></script>
    <script>
        $(function () {
            $.eventsource({
                label: "event-vote",
                url: "hello-sse",
                dataType: "text",
                open: function (data) {
                    console.log(data);
                },
                up_vote: function (data) {
                    console.log("up_vote : "+data);
                    $('up').val('1');
                },
                down_vote: function (data) {
                    console.log("down_vote : "+data);
                    $('down').val('2');
                }
            });
        });
    </script>
</head>
<body>
Jquery Polyfill <p/>
Up vote: <span id="up"></span> Down vote: <span id="down"></span>
</body>
</html>
