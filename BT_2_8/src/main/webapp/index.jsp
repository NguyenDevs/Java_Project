<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Nguyễn Tài Nguyên</title>
<style>
    @charset "UTF-8";
body{
    background-repeat: no-repeat;
    margin: 0;
    transition: .5s;
    background-repeat: no-repeat;
    background-attachment: fixed;
	background: linear-gradient(-45deg,#ffffff, #e478e1, #40f3fc);
	background-size: 400% 400%;
	animation: gradient 20s ease infinite;
	height: 100vh;

}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}
.form{
	padding-left: 20px;
    margin-top: 100px;
    border: double;
    width: 450px;
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 30px;
    border-radius: 10px;
    height: 300px;
}
.access{
    display: grid;
    margin-left: 240px;
    margin-top: -45px;
}
.proces{
    display: grid;
    margin-left: 10px;
}
.texter{
    display: block;
    padding-left: 10px;
    text-align: right;
    margin-right: 370px;
    
}
.radioer{
    margin-left: 40px;
}
.checker{
    display: flex;
    margin-left: 275px;
    margin-top: -60px;


}
#optionsTable{
    border: double black;
    border-radius: 10px;
    margin-left: 280px;
    margin-top: -10px;
    width: 100px;
    padding-left: 10px;
   
    
}

h2{
	text-align: left;
	padding-left: 20px;
}
.button{
    margin-top: 50px;
    margin-bottom: 30px;
    text-align: center;
    border: none;
    width: 150px;
    height: 40px;
    border-radius: 5px;
    background-color: rgb(13, 233, 189);
    margin-left: auto;
    margin-right: auto;
    display: grid;
    box-shadow: 0px 5px 0px #105e6735;
    transition: .5s;
}
.button:active{
    box-shadow: none;
    transform: translate(5px);
    color: white;
}
    </style>
<link rel="icon" type="image/x-icon" href="vuted.png">
</head>

<body>
    <form class="form"action="reciept.jsp" method="post">
        <h2 class="proces">Processor</h2>
        <h2 class="access">Accessories</h2>
        <label class="radioer">
            <input type="radio" name="processor"> Celeron D
        </label>
        <br>
        <label class="radioer">
            <input type="radio" name="processor"> Pentium IV
        </label>
        <br>
        <label class="radioer">
            <input type="radio" name="processor"> Pentium D
        </label >
        <label class="checker">
            <input type="checkbox" name="checkboxA" value="checkboxA" onclick="enableCheckboxes()"> Monitor
        </label>
        <br>
        <div id="optionsTable">
<input type="checkbox" name="checkboxB" value="checkboxB" disabled> Camera<br>
<input type="checkbox" name="checkboxC" value="checkboxC" disabled> Printer<br>
<input type="checkbox" name="checkboxD" value="checkboxD" disabled> Scanner<br>
        </div>
     
        <br>
        
        
        <input class="button"type="submit" value="PURCHASE">
    </form>
     <script>
        function enableCheckboxes() {
            var checkboxA = document.getElementsByName("checkboxA")[0];
            var childCheckboxes = document.querySelectorAll('input[name^="checkbox"]');

            if (checkboxA.checked) {
                for (var i = 0; i < childCheckboxes.length; i++) {
                    childCheckboxes[i].disabled = false;
                }
            } else {
                for (var i = 0; i < childCheckboxes.length; i++) {
                    childCheckboxes[i].disabled = true;
                    childCheckboxes[i].checked = false;
                }
            }
        }
    </script>
</body>
</html>