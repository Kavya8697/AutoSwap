import React, { useState } from "react";

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [isBuyer, setIsBuyer] = useState(false);


    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);

    }

    return (
        <div className="auth-form-container">
            <h2>Register</h2>
        <form className="register-form" onSubmit={handleSubmit}>
            <label htmlFor="firstName">First name</label>
            <input value={firstName} name="firstName" onChange={(e) => setFirstName(e.target.value)} id="firstName" placeholder="First Name" />
            <label htmlFor="lastName">Last name</label>
            <input value={lastName} name="lastName" onChange={(e) => setLastName(e.target.value)} id="lastName" placeholder="Last Name" />
            <label htmlFor="email">Email</label>
            <input value={email} onChange={(e) => setEmail(e.target.value)}type="email" placeholder="youremail@gmail.com" id="email" name="email" />
            <label htmlFor="password">Password</label>
            <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="********" id="password" name="password" />

            <br/>
            <button type="submit">Log In</button>
        </form>
        <button className="link-btn" onClick={() => props.onFormSwitch('login')}>Already have an account? Login here.</button>

    </div>
    )
}