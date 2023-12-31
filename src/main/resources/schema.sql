CREATE SCHEMA IF NOT EXISTS public AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS property (
                                    id VARCHAR PRIMARY KEY,
                                    property_type VARCHAR(255),
                                    title VARCHAR(255),
                                    description VARCHAR(255),
                                    status VARCHAR(50),
                                    private_description VARCHAR(255),
                                    agent VARCHAR(255),
                                    show_prices BOOLEAN,
                                    bedrooms INT,
                                    bathrooms INT,
                                    half_bathrooms INT,
                                    parking_spaces INT,
                                    age VARCHAR(50),
                                    floor VARCHAR(50),
                                    floors INT,
                                    expenses VARCHAR(255),
                                    share_commission BOOLEAN,
                                    collaboration_notes VARCHAR(255),
                                    show_exact_location BOOLEAN,
                                    construction_size DOUBLE PRECISION,
                                    lot_size DOUBLE PRECISION,
                                    lot_length INT,
                                    lot_width INT,
                                    covered_space DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS locations (
                                    id SERIAL PRIMARY KEY,
                                    property_id VARCHAR REFERENCES property(id),
                                    name_location VARCHAR(255),
                                    street VARCHAR(255),
                                    exterior_number VARCHAR(50),
                                    interior_number VARCHAR(50),
                                    cross_street VARCHAR(255),
                                    postal_code VARCHAR(20),
                                    latitude DOUBLE PRECISION,
                                    longitude DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS operations (
                                         id SERIAL PRIMARY KEY,
                                         property_id VARCHAR REFERENCES property(id),
                                            operation VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS images (
                                     id SERIAL PRIMARY KEY,
                                     property_id VARCHAR REFERENCES property(id),
                                    image VARCHAR(255)
    );