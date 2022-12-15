const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/*signUpButton.addEventListener('click', () =>
container.classList.add('right-panel-active'));

signInButton.addEventListener('click', () =>
container.classList.remove('right-panel-active'));
*/

var password = document.getElementById('password');

var toggler1 = document.getElementById('toggler1');


showHidePassword1 = () => {
	if (password.type == 'password') {
		password.setAttribute('type', 'text');
		toggler1.classList.add('fa-eye-slash');
	} else {
		toggler1.classList.remove('fa-eye-slash');
		password.setAttribute('type', 'password');
	}
	
};


toggler1.addEventListener('click', showHidePassword1);

