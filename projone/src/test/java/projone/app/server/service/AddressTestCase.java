package projone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projone.app.server.repository.AddressRepository;
import projone.app.shared.location.Address;
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
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("zPV6xaRuGshzczvBA0Mm4whCTNl10cTN4roEBavYJNM5thE4jj");
            addresstype.setAddressTypeDesc("PzppGuu5sezion8HuBguHCborKNdgsFGezuhz6f7VlOcJmps2m");
            addresstype.setAddressTypeIcon("2CCejhzbPhuANuJfasc9BlyBGtbEeSQNjO3Vt3GBZjdJ9slPWo");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("39LyvJNUZSWSZCBSVpMQ2IZLuEjV6TDL");
            city.setCityDescription("l4fZyfZ5yQtidyzO2TjHcSRTRND2clInfPEyOiRRHBN5i4d2JT");
            city.setCityFlag("gUv6OExg6IJfrVlP31t4xPrgzMvin4RBmgtCzeNXgeklKKjAoV");
            city.setCityLatitude(10);
            city.setCityLongitude(10);
            city.setCityName("0VtFZn3aWseqLbWdpM44en9Bfs04cNwVqg0GDlT1CBqOm8c6Bd");
            Country country = new Country();
            country.setCapital("w4teOIubaM6XS0RYcCf21IWR9NBuZRIg");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(4);
            country.setCountryCode1("0OD");
            country.setCountryCode2("AHG");
            country.setCountryFlag("CLdewm4wuUoccgDRgwEMPNUtXqRmULp5W36yw4okzVPiumn9zB");
            country.setCountryName("kfnbSPkm44pNr3RfF9fvXFY8ZhG68cEJjOB0RfCNpYkZcjbTQ4");
            country.setCurrencyCode("9ri");
            country.setCurrencyName("AIEB1PG6XdLrcZeuBrx86FyPrP8HZ8Oxd26TNfG6PXa8ddCDCc");
            country.setCurrencySymbol("Fj7dfhUnQQuRIrVbX39aMp0dT7DnoETU");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("vWSGPSf4C3NAvH5lIWXmuq6WTfLArRxsiI0LyDPBP7hFkINhOx");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(4);
            state.setStateCode(0);
            state.setStateCodeChar2("2nmiGnW8y9R3A2pyKSe7P1EYvcrp1qEG");
            state.setStateCodeChar3("3IsnneazA45gEVfcy1nuX50ePurVYqyg");
            state.setStateDescription("Q9tsqjm7H9tHxiQlkcCxN7exfPgTGwFb3yL6lhYMYouFNTgcjP");
            state.setStateFlag("Y0pCr9W7VHstvk3YxDY4Kpr7HvaxcrJ99qGtQJrZyu5p1vCX5m");
            state.setStateName("SiSJUX6NdDlrqE89oiaNUpTdVt3rHGgXiNVkW7UaxHvhHn75id");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("5wljc8O4B3mQWcoleq0atJkXr8crTCGa");
            city.setCityDescription("sRgMCJDt4L8ZEm7PvxdG5DJagBiDmKkv5dcCEvMV3pJW1GFwkw");
            city.setCityFlag("7jPiM9pj0tZlie8OynJSG98dHhEApaDdeR5bBR0Z8P3eVSWefh");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("DxPaEArIwvtMa5183h36iTgsBkb4odGeK0zS3ign1Vjb2K2tRw");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("SPDFJQVW6jYenslmdVj95dMQiSOD0K73vyZ8WsfrheIv67hRHp");
            address.setAddress2("coeyNa0zrpKr0uBWB26da4F4KA2uZh2ONJM6iWHcfmMLfYpCoJ");
            address.setAddress3("6pIkcrXdKjr7ZnYaFOHOF2OKXIYAeMbWVnSQtl0CmUbCYFIcKy");
            address.setAddressLabel("bw1F7VEDQkA");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("eh7cKFNgCZ9d6FcGhQ8dGdu2snoGan8zJ906fzPg33pMkMMYyX");
            address.setLongitude("ELSdmJJvvVYrNSW8sFenaIHPl7P2eqtLIhCTwu7Fh3viYKoEgP");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("hW3tf2");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("Vu5OiQZdNdeODuVRrqA0hpRUI4s9Cc2jtgCoGj53WoeFm2z2ae");
            address.setAddress2("VjBwmZE9R7N5tYnukHtguJGMfg7rMmDJuYU8VoHvYb7ifWqU3R");
            address.setAddress3("IrBb4ry8QPi5hy9ljMJWMMz1zDfI8fV9znjknOTS4VHjD7gRCc");
            address.setAddressLabel("Adt27Qrhke4");
            address.setLatitude("Eggq5teNDTeekCVKkyETvtWYfo9kUbpcgesGh2QgOQz8oL7x43");
            address.setLongitude("N0a13npx5DAxhyZdiokQhcoTNIYw4XPANyXBuRhGZI27v9HsXl");
            address.setVersionId(1);
            address.setZipcode("vysXTu");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
