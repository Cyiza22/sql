-- Doctors
INSERT INTO doctors (first_name, last_name, specialty, phone_number, email)
VALUES
    ('John', 'Doe', 'Cardiology', '123-456-7890', 'john.doe@hospital.com'),
    ('Jane', 'Smith', 'Pediatrics', '234-567-8901', 'jane.smith@hospital.com');

-- Patients
INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES
    ('Alice', 'Brown', '1990-05-12', 'Female', '345-678-9012', 'alice.brown@example.com'),
    ('Bob', 'Johnson', '1985-11-23', 'Male', '456-789-0123', 'bob.johnson@example.com');

-- Appointments
INSERT INTO appointments (doctor_id, patient_id, appointment_date, status)
VALUES
    (1, 1, '2025-06-01 10:00:00', 'Scheduled'),
    (2, 2, '2025-06-02 11:00:00', 'Completed');

-- Medical Records
INSERT INTO medical_records (patient_id, diagnosis, treatment, doctor_id)
VALUES
    (1, 'Flu', 'Rest and hydration', 1),
    (2, 'Asthma', 'Inhaler prescribed', 2);

-- Doctor-Patient relationships
INSERT INTO doctor_patient (doctor_id, patient_id)
VALUES
    (1, 1),
    (2, 2);
