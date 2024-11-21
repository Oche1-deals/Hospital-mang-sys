insert into patients(date_of_birth, registration_date, id, allergies, blood_type, email, gender, medical_history,
 name, phone)
values(current_date(), current_date(), 10001, 'none', 'o', 'odoh1', 'male', 'none', 'raph','none');

insert into patients(date_of_birth, registration_date, id, allergies, blood_type, email, gender, medical_history,
 name, phone)
values(current_date(), current_date(), 10002, 'none', 'A', 'oche2', 'female', 'none', 'oche','none');

insert into doctor(availability, id, first_name, last_name, email, phone_no, specialization)
values('yes', 30001, 'peter', 'fox', 'doctor1@gmail', 'none', 'surgeon');

insert into doctor(availability, id, first_name, last_name, email, phone_no, specialization)
values('no', 30002, 'abraham', 'shild', 'nurse12@gmail', 'none', 'nurse');

insert into medical_record(visit_date, id, patient_id, diagnosis, prescription, treatment)
values( current_date(), 4001, 5000, 'fever', 'parnadol', 'injection');

insert into medical_record(visit_date, id, patient_id, diagnosis, prescription, treatment)
values( current_date(), 4002, 5001, 'high fever', 'parnadol', 'injections');

insert into appointment(appointment_date_time, doctor_id, id, patient_id, status)
values(current_date(), 30001, 6000, 10001, 'set');

insert into appointment(appointment_date_time, doctor_id, id, patient_id, status)
values(current_date(), 30002, 6001, 10002, 'set');

insert into notification(sent, id, timestamp, message, recipient, type)
values(true, 70001, current_date(), 'i need help', 'doctor', 'sms');

insert into notification(sent, id, timestamp, message, recipient, type)
values(false, 70002, current_date(), 'i need help', 'nurse', 'Email');

insert into staff(hire_date, salary, id, email, first_name, last_name, phone, role)
values(current_date(), 2000.00, 80001, 'staff11@gmail', 'mary', 'jane', 'none', 'secetery');

insert into staff(hire_date, salary, id, email, first_name, last_name, phone, role)
values(current_date(), 3000.00, 80002, 'worker45@gmail', 'james', 'jonson', 'none', 'nurse');