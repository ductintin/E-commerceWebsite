const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/*signUpButton.addEventListener('click', () =>
container.classList.add('right-panel-active'));

signInButton.addEventListener('click', () =>
container.classList.remove('right-panel-active'));*/

var oldpw = document.getElementById('oldpw');
var newpw = document.getElementById('newpw');
var confirmnewpw = document.getElementById('confirmnewpw');

var toggler1 = document.getElementById('toggler1');
var toggler2 = document.getElementById('toggler2');
var toggler3 = document.getElementById('toggler3');

showHidePassword1 = () => {
	if (oldpw.type == 'password') {
		oldpw.setAttribute('type', 'text');
		toggler1.classList.add('fa-eye-slash');
	} else {
		toggler1.classList.remove('fa-eye-slash');
		oldpw.setAttribute('type', 'password');
	}
	
};

showHidePassword2 = () => {
	if (newpw.type == 'password') {
		newpw.setAttribute('type', 'text');
		toggler2.classList.add('fa-eye-slash');
	} else {
		toggler2.classList.remove('fa-eye-slash');
		newpw.setAttribute('type', 'password');
	}
	
};

showHidePassword3 = () => {
	if (confirmnewpw.type == 'password') {
		confirmnewpw.setAttribute('type', 'text');
		toggler3.classList.add('fa-eye-slash');
	} else {
		toggler3.classList.remove('fa-eye-slash');
		confirmnewpw.setAttribute('type', 'password');
	}
	
};

toggler1.addEventListener('click', showHidePassword1);
toggler2.addEventListener('click', showHidePassword2);
toggler3.addEventListener('click', showHidePassword3);