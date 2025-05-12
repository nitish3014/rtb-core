
CREATE TABLE public.addresses (
    address_id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    address_line1 character varying(255) NOT NULL,
    address_line2 character varying(255),
    city character varying(255) NOT NULL,
    country character varying(255) NOT NULL,
    postal_code character varying(255) NOT NULL,
    state character varying(255) NOT NULL,
    user_id bigint
);


ALTER TABLE public.addresses OWNER TO postgres;


CREATE SEQUENCE public.addresses_address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.addresses_address_id_seq OWNER TO postgres;


ALTER SEQUENCE public.addresses_address_id_seq OWNED BY public.addresses.address_id;


CREATE TABLE public.app_config (
    id bigint NOT NULL,
    config_name character varying(255),
    config_type character varying(255),
    config_value text,
    service_name character varying(255),
    tenant_id bigint NOT NULL,
    CONSTRAINT app_config_config_type_check CHECK (((config_type)::text = ANY ((ARRAY['VALUE'::character varying, 'ENV'::character varying])::text[])))
);


ALTER TABLE public.app_config OWNER TO postgres;


CREATE SEQUENCE public.app_config_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.app_config_id_seq OWNER TO postgres;


ALTER SEQUENCE public.app_config_id_seq OWNED BY public.app_config.id;


CREATE TABLE public.app_statistics_gcs_info (
    id bigint NOT NULL,
    gcs_bucket_name character varying(255),
    tenant_id bigint
);


ALTER TABLE public.app_statistics_gcs_info OWNER TO postgres;


CREATE SEQUENCE public.app_statistics_gcs_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.app_statistics_gcs_info_id_seq OWNER TO postgres;


ALTER SEQUENCE public.app_statistics_gcs_info_id_seq OWNED BY public.app_statistics_gcs_info.id;


CREATE TABLE public.communication (
    id bigint NOT NULL,
    active boolean,
    category character varying(255),
    communication_channel character varying(255),
    template_url character varying(255),
    tenant_id bigint,
    CONSTRAINT communication_category_check CHECK (((category)::text = ANY ((ARRAY['WELCOME_EMAIL'::character varying, 'ACCESS_CREDENTIALS'::character varying, 'PAYMENT_CONFIRMATION'::character varying, 'OTP_VERIFICATION'::character varying, 'PASSWORD_RESET'::character varying])::text[]))),
    CONSTRAINT communication_communication_channel_check CHECK (((communication_channel)::text = ANY ((ARRAY['EMAIL'::character varying, 'SMS'::character varying, 'PUSH'::character varying])::text[])))
);


ALTER TABLE public.communication OWNER TO postgres;


CREATE TABLE public.communication_channel (
    id bigint NOT NULL,
    active boolean,
    communication_channel character varying(255),
    tenant_id bigint,
    CONSTRAINT communication_channel_communication_channel_check CHECK (((communication_channel)::text = ANY ((ARRAY['EMAIL'::character varying, 'SMS'::character varying, 'PUSH'::character varying])::text[])))
);


ALTER TABLE public.communication_channel OWNER TO postgres;


CREATE SEQUENCE public.communication_channel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.communication_channel_id_seq OWNER TO postgres;


ALTER SEQUENCE public.communication_channel_id_seq OWNED BY public.communication_channel.id;


CREATE SEQUENCE public.communication_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.communication_id_seq OWNER TO postgres;


ALTER SEQUENCE public.communication_id_seq OWNED BY public.communication.id;


CREATE TABLE public.feature (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    feature_description character varying(255),
    feature_name character varying(255) NOT NULL,
    is_mobile boolean,
    updated_at timestamp(6) without time zone
);


ALTER TABLE public.feature OWNER TO postgres;


CREATE SEQUENCE public.feature_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.feature_id_seq OWNER TO postgres;


ALTER SEQUENCE public.feature_id_seq OWNED BY public.feature.id;


CREATE TABLE public.feature_permission (
    feature_id bigint NOT NULL,
    permission_id bigint NOT NULL
);


ALTER TABLE public.feature_permission OWNER TO postgres;


CREATE TABLE public.feature_product (
    id bigint NOT NULL,
    feature_id bigint NOT NULL,
    product_id character varying(255) NOT NULL
);


ALTER TABLE public.feature_product OWNER TO postgres;


CREATE SEQUENCE public.feature_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.feature_product_id_seq OWNER TO postgres;

ALTER SEQUENCE public.feature_product_id_seq OWNED BY public.feature_product.id;


CREATE TABLE public.feature_subscription (
    id bigint NOT NULL,
    feature_name character varying(255),
    subscription_id bigint
);


ALTER TABLE public.feature_subscription OWNER TO postgres;


CREATE SEQUENCE public.feature_subscription_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.feature_subscription_id_seq OWNER TO postgres;


ALTER SEQUENCE public.feature_subscription_id_seq OWNED BY public.feature_subscription.id;


CREATE TABLE public.feedback_counter (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    last_fibonacci_a bigint,
    last_fibonacci_b bigint,
    last_review_date character varying(255),
    next_fibonacci_target bigint,
    open_count bigint,
    tenant_id bigint,
    user_id bigint
);


ALTER TABLE public.feedback_counter OWNER TO postgres;


CREATE SEQUENCE public.feedback_counter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.feedback_counter_id_seq OWNER TO postgres;

ALTER SEQUENCE public.feedback_counter_id_seq OWNED BY public.feedback_counter.id;

CREATE TABLE public.otp (
    id character varying(255) NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    resends integer,
    used boolean,
    validation_payload text,
    value character varying(255)
);


ALTER TABLE public.otp OWNER TO postgres;

CREATE TABLE public.permissions (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    permission_description character varying(255) NOT NULL,
    permission_name character varying(255) NOT NULL
);


ALTER TABLE public.permissions OWNER TO postgres;

CREATE SEQUENCE public.permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.permissions_id_seq OWNER TO postgres;

ALTER SEQUENCE public.permissions_id_seq OWNED BY public.permissions.id;

CREATE TABLE public.products (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    category character varying(255) NOT NULL,
    is_digital boolean,
    name character varying(255) NOT NULL,
    price double precision NOT NULL,
    rating double precision,
    stock integer NOT NULL,
    url character varying(255) NOT NULL,
    tenant_id bigint
);


ALTER TABLE public.products OWNER TO postgres;

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_id_seq OWNER TO postgres;

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;

CREATE TABLE public.quicksight_dashboard (
    dashboard_id uuid NOT NULL,
    authenticated_url character varying(255),
    category character varying(255),
    description character varying(255),
    display_order integer,
    last_generated_at timestamp(6) without time zone,
    report_name character varying(255),
    tenant_id integer
);


ALTER TABLE public.quicksight_dashboard OWNER TO postgres;

CREATE TABLE public.refresh_tokens (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    last_used timestamp(6) without time zone NOT NULL,
    refresh_token_hash character varying(255) NOT NULL,
    revoked boolean NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE public.refresh_tokens OWNER TO postgres;

CREATE SEQUENCE public.refresh_tokens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.refresh_tokens_id_seq OWNER TO postgres;

ALTER SEQUENCE public.refresh_tokens_id_seq OWNED BY public.refresh_tokens.id;

CREATE TABLE public.role_permissions (
    role_id bigint NOT NULL,
    permission_id bigint NOT NULL
);


ALTER TABLE public.role_permissions OWNER TO postgres;

CREATE TABLE public.roles (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    role_description character varying(255) NOT NULL,
    role_name character varying(255) NOT NULL,
    tenant_id bigint
);


ALTER TABLE public.roles OWNER TO postgres;

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.roles_id_seq OWNER TO postgres;

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;

CREATE TABLE public.subscription (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    currency character varying(255),
    duration_in_months integer,
    end_date timestamp(6) without time zone,
    product_id character varying(255),
    start_date timestamp(6) without time zone,
    subscription_tier character varying(255),
    subscription_description character varying(255),
    subscription_name character varying(255),
    subscription_price real,
    tenant_id bigint,
    CONSTRAINT subscription_currency_check CHECK (((currency)::text = ANY ((ARRAY['USD'::character varying, 'INR'::character varying])::text[]))),
    CONSTRAINT subscription_subscription_tier_check CHECK (((subscription_tier)::text = ANY ((ARRAY['FREE'::character varying, 'BASIC'::character varying, 'PRO'::character varying])::text[])))
);


ALTER TABLE public.subscription OWNER TO postgres;

CREATE SEQUENCE public.subscription_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.subscription_id_seq OWNER TO postgres;

ALTER SEQUENCE public.subscription_id_seq OWNED BY public.subscription.id;

CREATE TABLE public.tenant (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    about_us_link character varying(255),
    address character varying(255),
    api_key character varying(255),
    description character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    is_enabled boolean NOT NULL,
    logo character varying(255),
    long_name character varying(255) NOT NULL,
    phone_number character varying(255),
    primary_color character varying(255),
    privacy_policy_link character varying(255),
    secondary_color character varying(255),
    short_name character varying(255) NOT NULL,
    terms_conditions_link character varying(255),
    twitter_handle character varying(255),
    upload_csv_faq character varying(255),
    youtube_handle character varying(255)
);


ALTER TABLE public.tenant OWNER TO postgres;

CREATE TABLE public.tenant_config (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    config_data jsonb NOT NULL,
    tenant_id bigint NOT NULL
);


ALTER TABLE public.tenant_config OWNER TO postgres;

CREATE SEQUENCE public.tenant_config_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tenant_config_id_seq OWNER TO postgres;

ALTER SEQUENCE public.tenant_config_id_seq OWNED BY public.tenant_config.id;


CREATE TABLE public.tenant_features (
    feature_id bigint NOT NULL,
    tenant_id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone
);


ALTER TABLE public.tenant_features OWNER TO postgres;

CREATE SEQUENCE public.tenant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tenant_id_seq OWNER TO postgres;

ALTER SEQUENCE public.tenant_id_seq OWNED BY public.tenant.id;

CREATE TABLE public.user_details (
    id uuid NOT NULL,
    date_of_birth date,
    email character varying(255) NOT NULL,
    first_name character varying(255),
    gender character varying(255),
    last_name character varying(255),
    password character varying(255) NOT NULL,
    profile_pic_url character varying(255),
    username character varying(255) NOT NULL
);


ALTER TABLE public.user_details OWNER TO postgres;

CREATE TABLE public.user_feedback (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    feedback character varying(255),
    rating double precision,
    tenant_id bigint,
    user_id bigint
);


ALTER TABLE public.user_feedback OWNER TO postgres;

CREATE SEQUENCE public.user_feedback_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_feedback_id_seq OWNER TO postgres;

ALTER SEQUENCE public.user_feedback_id_seq OWNED BY public.user_feedback.id;

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

CREATE TABLE public.user_subscriptions (
    id character varying(255) NOT NULL,
    end_date timestamp(6) without time zone,
    order_status character varying(255) NOT NULL,
    start_date timestamp(6) without time zone,
    subscription_id bigint NOT NULL,
    user_id bigint NOT NULL
);


ALTER TABLE public.user_subscriptions OWNER TO postgres;

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    apple_id character varying(255),
    deleted_at timestamp(6) without time zone,
    last_login timestamp(6) without time zone,
    status character varying(20) DEFAULT 'active'::character varying NOT NULL,
    tenant_id bigint,
    verified boolean NOT NULL,
    user_details_id uuid NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;

ALTER TABLE ONLY public.addresses ALTER COLUMN address_id SET DEFAULT nextval('public.addresses_address_id_seq'::regclass);

ALTER TABLE ONLY public.app_config ALTER COLUMN id SET DEFAULT nextval('public.app_config_id_seq'::regclass);

ALTER TABLE ONLY public.app_statistics_gcs_info ALTER COLUMN id SET DEFAULT nextval('public.app_statistics_gcs_info_id_seq'::regclass);

ALTER TABLE ONLY public.communication ALTER COLUMN id SET DEFAULT nextval('public.communication_id_seq'::regclass);

ALTER TABLE ONLY public.communication_channel ALTER COLUMN id SET DEFAULT nextval('public.communication_channel_id_seq'::regclass);

ALTER TABLE ONLY public.feature ALTER COLUMN id SET DEFAULT nextval('public.feature_id_seq'::regclass);

ALTER TABLE ONLY public.feature_product ALTER COLUMN id SET DEFAULT nextval('public.feature_product_id_seq'::regclass);

ALTER TABLE ONLY public.feature_subscription ALTER COLUMN id SET DEFAULT nextval('public.feature_subscription_id_seq'::regclass);

ALTER TABLE ONLY public.feedback_counter ALTER COLUMN id SET DEFAULT nextval('public.feedback_counter_id_seq'::regclass);

ALTER TABLE ONLY public.permissions ALTER COLUMN id SET DEFAULT nextval('public.permissions_id_seq'::regclass);

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);

ALTER TABLE ONLY public.refresh_tokens ALTER COLUMN id SET DEFAULT nextval('public.refresh_tokens_id_seq'::regclass);


ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


ALTER TABLE ONLY public.subscription ALTER COLUMN id SET DEFAULT nextval('public.subscription_id_seq'::regclass);


ALTER TABLE ONLY public.tenant ALTER COLUMN id SET DEFAULT nextval('public.tenant_id_seq'::regclass);

ALTER TABLE ONLY public.tenant_config ALTER COLUMN id SET DEFAULT nextval('public.tenant_config_id_seq'::regclass);

ALTER TABLE ONLY public.user_feedback ALTER COLUMN id SET DEFAULT nextval('public.user_feedback_id_seq'::regclass);

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT addresses_pkey PRIMARY KEY (address_id);

ALTER TABLE ONLY public.app_config
    ADD CONSTRAINT app_config_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.app_statistics_gcs_info
    ADD CONSTRAINT app_statistics_gcs_info_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.communication_channel
    ADD CONSTRAINT communication_channel_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.communication
    ADD CONSTRAINT communication_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.feature_permission
    ADD CONSTRAINT feature_permission_pkey PRIMARY KEY (feature_id, permission_id);


ALTER TABLE ONLY public.feature
    ADD CONSTRAINT feature_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.feature_product
    ADD CONSTRAINT feature_product_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.feature_subscription
    ADD CONSTRAINT feature_subscription_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.feedback_counter
    ADD CONSTRAINT feedback_counter_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.otp
    ADD CONSTRAINT otp_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.quicksight_dashboard
    ADD CONSTRAINT quicksight_dashboard_pkey PRIMARY KEY (dashboard_id);

ALTER TABLE ONLY public.refresh_tokens
    ADD CONSTRAINT refresh_tokens_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.role_permissions
    ADD CONSTRAINT role_permissions_pkey PRIMARY KEY (role_id, permission_id);


ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.subscription
    ADD CONSTRAINT subscription_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.tenant_config
    ADD CONSTRAINT tenant_config_pkey PRIMARY KEY (id);


ALTER TABLE ONLY public.tenant_features
    ADD CONSTRAINT tenant_features_pkey PRIMARY KEY (feature_id, tenant_id);

ALTER TABLE ONLY public.tenant
    ADD CONSTRAINT tenant_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.tenant
    ADD CONSTRAINT uk_1wuu4ilo8ya2tm94iswtp6ev1 UNIQUE (email);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_4ai7rrtrvwtgtqavv8okpxrul UNIQUE (user_details_id);


ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT uk_4d9rdl7d52k8x3etihxlaujvh UNIQUE (email);

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT uk_716hgxp60ym1lifrdgp67xt5k UNIQUE (role_name);


ALTER TABLE ONLY public.tenant_config
    ADD CONSTRAINT uk_ef8qgyim87qokmrbasb9irfog UNIQUE (tenant_id);

ALTER TABLE ONLY public.feature
    ADD CONSTRAINT uk_gqa31umtnrjdnp8r5vrh44doa UNIQUE (feature_name);

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT uk_nry1f3jmc4abb5yvkftlvn6vg UNIQUE (permission_name);

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT uk_qqadnciq8gixe1qmxd0rj9cyk UNIQUE (username);


ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.user_feedback
    ADD CONSTRAINT user_feedback_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);

ALTER TABLE ONLY public.user_subscriptions
    ADD CONSTRAINT user_subscriptions_pkey PRIMARY KEY (id, user_id, subscription_id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.addresses
    ADD CONSTRAINT fk1fa36y2oqhao3wgg2rw1pi459 FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.user_subscriptions
    ADD CONSTRAINT fk3l40lbyji8kj5xoc20ycwsc8g FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.tenant_features
    ADD CONSTRAINT fk6milucqfvnqi4kakiy4l8oj9t FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);

ALTER TABLE ONLY public.communication_channel
    ADD CONSTRAINT fk82e39w9okcrrkq193tmks5eoe FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk8uj8y5ad4xl01w9wcracimb14 FOREIGN KEY (user_details_id) REFERENCES public.user_details(id);

ALTER TABLE ONLY public.user_subscriptions
    ADD CONSTRAINT fkb5sq3r6j9httcp67kf6cxrcon FOREIGN KEY (subscription_id) REFERENCES public.subscription(id);

ALTER TABLE ONLY public.tenant_features
    ADD CONSTRAINT fkec6bgc7g9oius5rvug5uk9i01 FOREIGN KEY (feature_id) REFERENCES public.feature(id);

ALTER TABLE ONLY public.role_permissions
    ADD CONSTRAINT fkegdk29eiy7mdtefy5c7eirr6e FOREIGN KEY (permission_id) REFERENCES public.permissions(id);

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.feature_permission
    ADD CONSTRAINT fkjl211uiff652ff0uo2i34ngx9 FOREIGN KEY (permission_id) REFERENCES public.permissions(id);

ALTER TABLE ONLY public.communication
    ADD CONSTRAINT fkkt7jh0t7yw32frsytxuobs10n FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);

ALTER TABLE ONLY public.feature_permission
    ADD CONSTRAINT fklantt6pc0wjwueula2lt5vmt8 FOREIGN KEY (feature_id) REFERENCES public.feature(id);

ALTER TABLE ONLY public.role_permissions
    ADD CONSTRAINT fkn5fotdgk8d1xvo8nav9uv3muc FOREIGN KEY (role_id) REFERENCES public.roles(id);

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkr1fbovhlbox7fftnb8q3iowac FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);

ALTER TABLE ONLY public.tenant_config
    ADD CONSTRAINT fktc8m1hehgn1dlhrrat5u1293n FOREIGN KEY (tenant_id) REFERENCES public.tenant(id);