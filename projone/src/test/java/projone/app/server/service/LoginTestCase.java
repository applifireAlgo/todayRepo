package projone.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import projone.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import projone.app.server.repository.LoginRepository;
import projone.app.shared.authentication.Login;
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
import projone.app.shared.contacts.CoreContacts;
import projone.app.server.repository.CoreContactsRepository;
import projone.app.shared.contacts.Gender;
import projone.app.server.repository.GenderRepository;
import projone.app.shared.location.Language;
import projone.app.server.repository.LanguageRepository;
import projone.app.shared.location.Timezone;
import projone.app.server.repository.TimezoneRepository;
import projone.app.shared.contacts.Title;
import projone.app.server.repository.TitleRepository;
import projone.app.shared.authentication.User;
import projone.app.server.repository.UserRepository;
import projone.app.shared.authentication.UserAccessDomain;
import projone.app.server.repository.UserAccessDomainRepository;
import projone.app.shared.authentication.UserAccessLevel;
import projone.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(95);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("lZkQy2cSFE9jsXD0GnRJz2yeGAwVJ0sAUTQv9aSN7VlZRgyip7");
            corecontacts.setFirstName("KxzkBs1Ir2U2DQFebApFYbHFoAaL3cCGKlioKuZXdyuKsYPDWC");
            Gender gender = new Gender();
            gender.setGender("RspIHoGqweAIU7feBgk5TNFCm7K6lJnX4GXBzo8k7xukus7t4g");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("yx");
            language.setAlpha3("GGD");
            language.setAlpha4("i9wT");
            language.setAlpha4parentid(11);
            language.setLanguage("yB1gradfOak1w6aDpUMJTlYvvCK80XRD5cNXUQ9w4jmdWwNKYW");
            language.setLanguageDescription("OUxqqyKeItE1obmdSoi3J50QfpiFbBES0BKkA7NnvFLVVYXK17");
            language.setLanguageIcon("SUF72EnkqJCOBGJXLudPRZ5a99P85nOPC9tA0TeAvhrlXygfPf");
            language.setLanguageType("68zZFCYoc3VqwEyeVqcM4cjcUAo2naAC");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("LX9mVtqMgSHegtp8bHxfeoBxm8Jdpqer9oyRliU22LC7DwX7q1");
            timezone.setCountry("rD769ECSuGBRI4Cm9jDPeH3FY297ECoX0E3ZTgR8Fw0TaVAVPS");
            timezone.setGmtLabel("2lQ64vwJYC8QBiVkCaJtzC37jtjmJK8nXdHAbwPIg2Cfuql1ju");
            timezone.setTimeZoneLabel("fsbKU3PsPLovdYcbw0Ci88vFuthbR77C4UuhnLgnO3oN7N6KJV");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("PWyeFQcvmnncQxiPArBeEzWLUc7u0l9VuQJ3ReE4tGCh1E9xbn");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(108);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("PVtsBkae79nkG77yn5jOZqyM4cOAtHXrYwc6TIoN1LI9ePrlv8");
            corecontacts.setFirstName("pUjgloCecK1MECbL0V2tWWBzD0gu0qi4M4ByOVTMR4l0Him6PH");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("loSm4LyJ4xQ9L7FcUfUwjm3SX1YQPBFNnl4CVdZNflaxZRr497");
            corecontacts.setMiddleName("F7zXHpHURrNYwdLlXLBSshW59Kb9hgc9225j1gZESoDn3MduNe");
            corecontacts.setNativeFirstName("zmkL1mE929iAw5OE2w92UNZWMl1ZgbpY9jJcuaIoi8jc0v7BlX");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("fXVlMQccLSxdo1sk6YDU61SfDqpGHG7TDmFdPlSaJOxkbZtcmy");
            corecontacts.setNativeMiddleName("2Fq9Gnicd88IR3SHvvzrXaDT75u8rFfg9LZYzfFerUC6mwWJOX");
            corecontacts.setNativeTitle("iT6pQJL5P90w7i2O0NvS4FFOGbDN9DzRlDj5u7c3VOfHUQzscT");
            corecontacts.setPhoneNumber("0W8lVrpiDUdXzhySFHc5");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("ePlu0kxbtKwicIQWJXNLiWzDVxi80FuHsgUElSQWkZHEqK2zpA");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(217);
            user.setUserAccessCode(9);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("Z0TxooA8FgNGB2nUtZlLl9zdctKXiFmKUxIhoRaQmMqDhc0omt");
            useraccessdomain.setDomainHelp("F5XWsR4HP8XpLYHzVbSfyJ7gAkY29rDT5fE3X6iC5fa5tuMOIb");
            useraccessdomain.setDomainIcon("jtb29AP5FbWxo2mnirBPYj77sMGWcH7YZozF9qq4ZQHuXoFJjp");
            useraccessdomain.setDomainName("Ejkn4pC0EGrUTd3DCaOGutJwrRy2tRiIUFPIAnrNoxJiqCMeia");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("SpOKlJW8zi5gMLmaDz84CMA4tUWXgOAX9FhSVSX5B62pWJQx8V");
            useraccesslevel.setLevelHelp("j0fQIhtStPkkSc5dDKuGdNF8iHx5zPbSaWffYQNoB3TJpll97y");
            useraccesslevel.setLevelIcon("ZEYB6XSeZX2d8DQzEek3iqhr7hg8de4YxC8hcCXi6NL0H8rN9h");
            useraccesslevel.setLevelName("4R2QzMZ3cAL4JWniohLu8WXqS03Nc43xlN304zGJsCANfyLRyk");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("yZhy8J0YK7FUZ4Gp5rC0EdDOaq2sKjyuhiLBTSPEMKn01YtLr9");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(49);
            user.setUserAccessCode(0);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(8);
            login.setIsAuthenticated(true);
            login.setLoginId("Y55ndacqc4LhyJsW489OiQbE3VTLlt9mDmeY71K9WQHOAbIMwH");
            login.setServerAuthImage("7Sevlttf8DgDOKP9JpORk70LWae9gub5");
            login.setServerAuthText("Aij2MfzJ9MKB3Bn5");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(10);
            login.setLoginId("laczCGKui4un4bb3EIT2xy6sST4Qq28WXmJW7XL0qHa9CIm7nU");
            login.setServerAuthImage("vfUlPgNi1RxAUBMU65Euly1uRMTM442G");
            login.setServerAuthText("LzCz1fmIBUmCwDla");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
