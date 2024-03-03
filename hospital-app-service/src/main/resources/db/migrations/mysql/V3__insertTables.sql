INSERT INTO ADDRESS (ID_ADDRESS, ADDRESS1, ADDRESS2, CITY, LOCATION, POSTAL_CODE, FK_ID_COUNTRY) VALUES
    (1, '11957 Avenue Jubinville', '', 'Montreal', '', 'H1G 3T3', 1),
    (2, '123 Jean Talon', '', 'Montreal', '', 'H1G 2T2', 1);
commit;

-- ***********************************************
--   Insert Room
-- ***********************************************
INSERT INTO ROOM (ID_ROOM, NUMBER_ROOM, CAPACITY, TYPE_ROOM, NUMBER_OF_BEDS, BLOCK_FLOOR, UNAVAILABLE, BLOCK_CODE) VALUES
   (1, 11, 2, 'PRIVATE', 2, 1, 0, 'A'),
   (2, 12, 3, 'NOT_PRIVATE', 2, 1, 1, 'B');
commit;

-- ***********************************************
--   Insert CONSULTATION_TYPE
-- ***********************************************
INSERT INTO CONSULTATION_TYPE (ID_CONSULTATION_TYPE, NAME, DESCRIPTION, DEPARTMENT) VALUES
    (1, 'General Medicine', 'Comprehensive healthcare for general health concerns', 'Internal Medicine'),
    (2, 'Cardiology', 'Specialized care for heart-related issues', 'Cardiology'),
    (3, 'Ophthalmology', 'Diagnosis and treatment of eye conditions', 'Ophthalmology'),
    (4, 'Pediatrics', 'Medical care for infants, children, and adolescents', 'Pediatrics'),
    (5, 'Gynecology', 'Women\'s reproductive health', 'Obstetrics and Gynecology'),
    (6, 'Dermatology', 'Treatment of skin conditions', 'Dermatology'),
    (7, 'Neurology', 'Care for disorders of the nervous system', 'Neurology'),
    (8, 'Psychology', 'Mental health assessment and therapy', 'Psychiatry'),
    (9, 'Allergy and Immunology', 'Diagnosis and treatment of allergies and immune system disorders', 'Allergy and Immunology'),
    (10, 'Gastroenterology', 'Digestive system health and disorders', 'Gastroenterology'),
    (11, 'Rheumatology', 'Management of autoimmune and musculoskeletal disorders', 'Rheumatology'),
    (12, 'Oncology', 'Diagnosis and treatment of cancer', 'Oncology'),
    (13, 'Pulmonology', 'Respiratory system health and disorders', 'Pulmonology'),
    (14, 'Hematology', 'Study and treatment of blood-related disorders', 'Hematology'),
    (15, 'Nephrology', 'Kidney function and related health issues', 'Nephrology'),
    (16, 'Geriatrics', 'Healthcare for the elderly and age-related conditions', 'Geriatrics');
commit;

-- ***********************************************
--   Insert PROFESSIONAL_ACTIVITY
-- ***********************************************
INSERT INTO PROFESSIONAL_ACTIVITY (ID_PROFESSIONAL_ACTIVITY, NAME, DESCRIPTION) VALUES
    (1, 'General Medicine', 'Comprehensive healthcare for general health concerns'),
    (2, 'Cardiology', 'Specialized care for heart-related issues'),
    (3, 'Ophthalmology', 'Diagnosis and treatment of eye conditions'),
    (4, 'Pediatrics', 'Medical care for infants, children, and adolescents'),
    (5, 'Gynecology', 'Women\'s reproductive health'),
    (6, 'Dermatology', 'Treatment of skin conditions'),
    (7, 'Neurology', 'Care for disorders of the nervous system'),
    (8, 'Psychology', 'Mental health assessment and therapy'),
    (9, 'Orthopedics', 'Musculoskeletal system disorders and injuries'),
    (10, 'Dentistry', 'Oral health and dental care'),
    (11, 'Urology', 'Medical care for the urinary tract and male reproductive system'),
    (12, 'Endocrinology', 'Study and management of hormonal disorders'),
    (13, 'Allergy and Immunology', 'Diagnosis and treatment of allergies and immune system disorders'),
    (14, 'Gastroenterology', 'Digestive system health and disorders'),
    (15, 'Rheumatology', 'Management of autoimmune and musculoskeletal disorders'),
    (16, 'Oncology', 'Diagnosis and treatment of cancer'),
    (17, 'Pulmonology', 'Respiratory system health and disorders'),
    (18, 'Hematology', 'Study and treatment of blood-related disorders'),
    (19, 'Nephrology', 'Kidney function and related health issues'),
    (20, 'Geriatrics', 'Healthcare for the elderly and age-related conditions');
commit;