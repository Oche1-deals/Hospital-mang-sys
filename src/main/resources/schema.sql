insert into patients(date_of_birth, registration_date, id, allergies, blood_type, email, gender, medical_history,
 name, phone)
values(current_date(), current_date(), 10001, 'none', 'o', 'odoh1', 'male', 'none', 'raph','none');

insert into patients(date_of_birth, registration_date, id, allergies, blood_type, email, gender, medical_history,
 name, phone)
values(current_date(), current_date(), 10002, 'none', 'A', 'oche2', 'female', 'none', 'oche','none');

insert into doctor(availability, id, first_name, last_name, email, phone_no, specialization)
values('yes', 30001, 'peter', 'fox', 'doctor1@gmail', 'none', 'surgeon');