UPDATE appointments
SET status = 'Completed'
WHERE id = 1;

DELETE FROM patients
WHERE id = 2;

SELECT * FROM appointments WHERE appointment_date BETWEEN '2025-06-01' AND '2025-06-30';

-- Get patient names and their appointment dates
SELECT p.id, p.first_name, a.appointment_date
FROM patients p INNER JOIN appointments a ON p.id = a.patient_id;

-- Show all doctors and any appointments they may have
SELECT d.first_name, d.last_name, a.appointment_date, a.status
FROM doctors d LEFT JOIN appointments a ON d.id = a.doctor_id;

--Remove a patient by first name
DELETE FROM patients WHERE first_name = 'Alice';

SELECT * FROM Doctors;
SELECT * FROM Appointments;
SELECT * FROM Patients;
SELECT * FROM Appointments;
SELECT * FROM medical_records;