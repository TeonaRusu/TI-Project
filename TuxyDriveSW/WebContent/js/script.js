function welcomeDisplay()
    {
    	var x = document.getElementById("welcome");
        setTimeout(function(){ x.style.display = "none" }, 3000);
    }

function clearRegisterForm()
{
	document.getElementById('fname').value='';
	document.getElementById('lname').value='';
	document.getElementById('username').value='';
	document.getElementById('age').value='';
	document.getElementById('email').value='';
	document.getElementById('pswd1').value='';
	document.getElementById('pswd2').value='';
}