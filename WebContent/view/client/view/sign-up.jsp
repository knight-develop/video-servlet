<form action="/Assignment/register" method="post">
	<div class="sign-up-form">
		<div class="group">
			<label for="user" class="label">Username</label> <input id="user"
				type="text" class="input" placeholder="Create your Username"
				name="id">
		</div>
		<div class="group">
			<label for="pass" class="label">Password</label> <input id="pass"
				type="password" class="input" data-type="password"
				placeholder="Create your password" name="password">
		</div>
		<div class="group">
			<div class="group">
				<label for="pass" class="label">Repeat Password</label> <input
					id="pass" type="password" class="input" data-type="password"
					placeholder="Repeat your password" name="re_pass">
			</div>
			<label for="pass" class="label">Full name</label> <input id="pass"
				type="text" class="input" placeholder="Create your full name"
				name="fullName">
		</div>
		<div class="group">
			<label for="pass" class="label">Email Address</label> <input
				id="pass" type="text" class="input"
				placeholder="Enter your email address" name="email">
		</div>
		<input name="admin" hidden="hidden" type="radio"/>
		<div class="group">
			<input type="submit" class="button" value="Sign Up">
		</div>
		<div class="hr"></div>
		<div class="foot">
			<label for="tab-1">Already Member?</label>
		</div>
	</div>
</form>