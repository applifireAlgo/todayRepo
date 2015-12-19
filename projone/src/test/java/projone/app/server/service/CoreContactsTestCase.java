package projone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projone.app.server.repository.CoreContactsRepository;
import projone.app.shared.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import projone.app.shared.contacts.Gender;
import projone.app.server.repository.GenderRepository;
import projone.app.shared.location.Language;
import projone.app.server.repository.LanguageRepository;
import projone.app.shared.location.Timezone;
import projone.app.server.repository.TimezoneRepository;
import projone.app.shared.contacts.Title;
import projone.app.server.repository.TitleRepository;
import projone.app.shared.contacts.CommunicationData;
import projone.app.shared.contacts.CommunicationGroup;
import projone.app.server.repository.CommunicationGroupRepository;
import projone.app.shared.contacts.CommunicationType;
import projone.app.server.repository.CommunicationTypeRepository;
import projone.app.shared.location.Address;
import projone.app.server.repository.AddressRepository;
import projone.app.shared.location.AddressType;
import projone.app.server.repository.AddressTypeRepository;
import projone.app.shared.location.City;
import projone.app.server.repository.CityRepository;
import projone.app.shared.location.Country;
import projone.app.server.repository.CountryRepository;
import projone.app.shared.location.State;
import projone.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Gender gender = new Gender();
            gender.setGender("KavUVSXNCelZukO9VrrcUX4ntx48CNlCoWl41zvSjR9nIdzmJx");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("eq");
            language.setAlpha3("3wE");
            language.setAlpha4("ftt9");
            language.setAlpha4parentid(0);
            language.setLanguage("pXfUQXYVqPTunVZBvmbgFiQvrSkvarWBMXDvXeafGcb8FHuQK3");
            language.setLanguageDescription("SZCyWyKaM8KK7SIzju0DChM8SMgIiJkISDxJLkz3uqvjKzyFzQ");
            language.setLanguageIcon("TTMCcNgdh5iGZ33OXPWaLZhMSh8SQc0OCm9lYpvutewSBSxCXX");
            language.setLanguageType("F8YhZ4vAMdU1oKqviUmCqIt3QFDbttvY");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("X7Zhu2YMhP6pIGKezvGbnC09QwmdF2auFjzQSE5HrDntA21zOt");
            timezone.setCountry("anAIRSlDlqNHbsXJZGoqs6kX4mlAire22NssnWLbvx1XkVzPfY");
            timezone.setGmtLabel("6Xe5qNtFu6AXmAyIFfj0GQv5HzJlAvR5AZU75KiN1ryUyVYTE3");
            timezone.setTimeZoneLabel("4UpmaFZ6qr2alstD4yw8l17z3yugzTSvdbeRaBYHgbnwGVAUp4");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("OQM8ieRrLSyxbavxXpHKREaEsbtHesMBnw7CXqhhLjBXd79ARJ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(8);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("K4ZE5jEKVQaIoJTSjVxxYCaJ70AseBKYAT5m9Kz5yQY3wmpssK");
            corecontacts.setFirstName("e83D5H6K77O70aeLowTZUHQ3INPXFFFRzwzhiPIK29ufGeFHKL");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("meUsEorQSPOEYUfh1SMlUwfDchDqvgbCuLXHGZIyF3YQ4IzV1C");
            corecontacts.setMiddleName("41zosBqhGzzgoALBcAg9Csj80WZrUZXNKtzaCPFM4invW9hExK");
            corecontacts.setNativeFirstName("o5HhDIZLQBdQd2ofdT0tMe5cIa0C5UbywHvzZsCjRDSiop7oeo");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("f10RvJeVdE1sFBm7EISnKMD9zphTbBqEgHEbbIZTdXgRWSOdeT");
            corecontacts.setNativeMiddleName("qVxNtpMPPM23hsjo2WBMk5b6JEnWrqVFbww9Py0Mwof7qN0cKi");
            corecontacts.setNativeTitle("dGHZDNGnTe64Wa1AXPAFUUr6ammTIkKz0ppJoLNlXgDbSxwpFM");
            corecontacts.setPhoneNumber("uMJ6s4INtTvY6FUZzWoC");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("or2");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("2g0HZwIPL68WM5yIoOzGGyCSlWI4TiiSvPM9vVTun5XKRzbrgE");
            communicationgroup.setCommGroupName("FXwuFGQtllkwfZfI2arF2Hh9UyAG2MZqDtlS4oLMbxL7ofjGMw");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("S3DaXQhyQor5VmapQOyGi10iSS265DRBXyJhu8Q0w5hQtEefwn");
            communicationtype.setCommTypeName("V4bAz7ufbjItp8EQZkL9CfdeTq5MjexKkskOJPRJ23Vxo0NYkh");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("iuk");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("0wfZa0EJB1TqbvXZtoCUEzRwjB0HTV9vPwCpHJldl0ZFdfxv3J");
            address.setAddress2("TFQQ3t9FDqexy6bI5sXuYKM0FpK74O4FoPnY4a8YpSLZ3unAv2");
            address.setAddress3("KPJaHlMs13lSsyhNqbrGrKUUngRD70m8hNJSC24xkIo3QksIh1");
            address.setAddressLabel("TBn58tCwk5x");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("5LiXGYI28vOOclZGME7h2l4QjlGZEfh4fzp796r8V0HFINtU3l");
            addresstype.setAddressTypeDesc("0bSDcmxHJR1lFbaASBzzYdgSxyjVpEA0oTVpJSdikuwGK2u5tS");
            addresstype.setAddressTypeIcon("q2ZxDhuSdElYH6HDg5z2ADlIDuf7WdYw9C4qnQ4gl8VWCDacTt");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("nQ1L9mFnXBh0hdrZIRXXkCJGoTeNivep");
            city.setCityDescription("5Kq2KtV7yGLTHjfS3iZpn60wSVBpjLOQilCq0EKHqyLpOjGllp");
            city.setCityFlag("cveVu9iHM5pP3Yq2i2V8Tl0K1z3AeUmUnCZp28ulCqjXuTLx6s");
            city.setCityLatitude(11);
            city.setCityLongitude(10);
            city.setCityName("7j0f1OPEK3ZTiQSpi2MjqJtE08iCAKIFAbcXrAjk804cFXHccd");
            Country country = new Country();
            country.setCapital("xRYCN8SVjrStAE5JDYs96ZXzFT8adkhq");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(4);
            country.setCountryCode1("dDW");
            country.setCountryCode2("EYv");
            country.setCountryFlag("F36pgpjvfe29ubAl7pAykvQLxErp8qalY805gI01rjn9ZkBkuP");
            country.setCountryName("ofqSRjR3Idwc3im3wodjiQw9Wb2ylm3KNn9rYYLI30rUxInu3s");
            country.setCurrencyCode("Zbt");
            country.setCurrencyName("dcL3hVE0xIh9wyUbkVTpFtgZDXIUvn5iMqQCkF5C0AVyZwqIEc");
            country.setCurrencySymbol("NN6yFSyVl8M7PGbdGPpujk1fvKJ2bxts");
            country.setIsoNumeric(3);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("BRIebBeXdMFaYfPZOWoD9I2TFds7CstG4AM9WzQOib4GGt77ab");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("ewCyIKooJ0DzY17waE6jQ48F1EL4kPAq");
            state.setStateCodeChar3("YMU33kTy7i4yQ9gILLFZIXyRZqTfBFy1");
            state.setStateDescription("BjgajTDmhSlPxnQrMaCW6DQkN3KqzTmdVKAd7pDcjwhbKgKzS2");
            state.setStateFlag("ROy4ZAeuvp5FjW9cRI2m3WXrUcveXXHnYBzNU1cYeYO3NT62oD");
            state.setStateName("9MMsjVNg4zKKQapsqy5uUyHFDZ15wbcH5FXzwx9oAzqeehWzrK");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("tQVZa7s7sdDdOMkzTFabgm20tuijKM7d");
            city.setCityDescription("2Yy3umqEhr50G3DlUESZsvoC8FpzRe2860BGzNlwOKZeMDthnK");
            city.setCityFlag("QcI0J02v67VN6p2CqRZDr4gzTDCWpZ9N9cUWdzdka13ghXDZg6");
            city.setCityLatitude(9);
            city.setCityLongitude(7);
            city.setCityName("eMAYYTvdhW5iEHrVCDpoSGBP3R29kAR3wPfnTKbNa7IBpi8UZE");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("gemJDtRcwDO13Ar3erBQbXqdQdmp8g0QplqKz0zTrEUVZQGja0");
            address.setAddress2("VP7EcThPnqvQFMUpqdosbljjsn8NTSeTcqVzz2ckHuzkKZIQ6W");
            address.setAddress3("5Syr8pyJBwAjXmhXOzvDTSRStTXQxQpwDWS9iuX2BENGvJNkFT");
            address.setAddressLabel("Bxyly68XesD");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("VUkEa441MoSRzTv0FOOPV75MrjLtwze5ymXoJ2DfH5o201eNRs");
            address.setLongitude("paR3LmIpAW3A3NCsyDLzsZTW5NTlPNfMKhyELDwjsPFk2XTKvV");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("YT5hwZ");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(24);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("Mk2WIKkZOjQgzYmbV9MjYl55wSax8Bv28ZxIHjJYoVZAvwW9W9");
            corecontacts.setFirstName("m7T8dfxRL2lmVxK1AhWuVk0iB30TtbSA6TbNLJgwhitmBQgA0h");
            corecontacts.setLastName("liz95jCfEMvOTHlATGcGzsgn02gsZLNqL45uMjkU1j62GbrxRc");
            corecontacts.setMiddleName("Z08NlXGGoEO6GunEaEPLOHs0UoIZaAiyPUZeu3GVqMFz0nmGSL");
            corecontacts.setNativeFirstName("rcOFZIqI0cUAGiDWwzVAC9VgE9mr5q11lXEYY5WrOaASvCP7c3");
            corecontacts.setNativeLastName("C82lo4CumsxghFGs3GoeH0dYE9RykoHPXd9cSOjwn2r4U6MeRb");
            corecontacts.setNativeMiddleName("FXLpCYL2aKfB94TYT6p2xGBLDwD9ar5WF6v3nFjw9dZG9LsSWf");
            corecontacts.setNativeTitle("ypKHYwiKus3ijom5wMvzem96B6yrcNvnkcSUo3Z0UbDN69t4gF");
            corecontacts.setPhoneNumber("DZPpwdr8inpPmYIbpsem");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
