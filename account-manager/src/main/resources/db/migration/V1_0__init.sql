CREATE TABLE IF NOT EXISTS public.customer
(
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.account
(
    id VARCHAR(255) NOT NULL,
    customer_id VARCHAR(255) NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (id),
    CONSTRAINT fk_1 FOREIGN KEY (customer_id)
    REFERENCES public.customer (id)
);