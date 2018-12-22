package hello.controller;

import hello.dao.*;
import hello.repo.*;
import hello.view.ResultSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class InsertUpdateController {
    @Autowired
    private OrganizationRepo organizationRepo;
    @Autowired
    private OfficeRepo officeRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private UserDocRepo userDocRepo;
    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private DocsRepo docsRepo;

    @GetMapping("organization/update")
    public ResultSuccess updateOrg(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "fullName") String fullName,
            @RequestParam(value = "inn") String inn,
            @RequestParam(value = "kpp") String kpp,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "isActive", required = false) Boolean isActive
    ) {
        Organization organization = new Organization(id, name, fullName, inn, kpp, address, phone, isActive);
        organizationRepo.save(organization);

        return new ResultSuccess("success");
    }

    @PostMapping("organization/update")
    public ResultSuccess updateOrgPost(@RequestBody Map<String, String> json) {
        Long id = json.get("id") == null ? null : Long.parseLong(json.get("id"));
        String name = json.get("name");
        String fullName = json.get("fullName");
        String inn = json.get("inn");
        String kpp = json.get("kpp");
        String address = json.get("address");
        String phone = json.get("phone");
        Boolean isActive = json.get("isActive") == null ? null : Boolean.parseBoolean(json.get("isActive"));

        return updateOrg(id, name, fullName, inn, kpp, address, phone, isActive);
    }

    @GetMapping("organization/save")
    public ResultSuccess saveOrg(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "fullName") String fullName,
            @RequestParam(value = "inn") String inn,
            @RequestParam(value = "kpp") String kpp,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "isActive", required = false) Boolean isActive
    ) {
        Organization organization = new Organization(name, fullName, inn, kpp, address, phone, isActive);

        organizationRepo.save(organization);
        return new ResultSuccess("success");
    }

    @PostMapping("organization/save")
    public ResultSuccess saveOrgPost(@RequestBody Map<String, String> json) {
        String name = json.get("name");
        String fullName = json.get("fullName");
        String inn = json.get("inn");
        String kpp = json.get("kpp");
        String phone = json.get("phone");
        String address = json.get("address");
        Boolean isActive = json.get("isActive") == null ? null : Boolean.parseBoolean(json.get("isActive"));

        return saveOrg(name, fullName, inn, kpp, address, phone, isActive);
    }

    @GetMapping("office/update")
    public ResultSuccess updateOfficeGet(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "orgId") Long orgId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "isActive", required = false) Boolean isActive
    ) {
        Optional<Organization> organization = organizationRepo.findById(orgId);
        Office office = new Office(id, organization.get(), name, address, phone, isActive);
        officeRepo.save(office);

        return new ResultSuccess("success");
    }

    @PostMapping("office/update")
    public ResultSuccess updateOffice(
            @RequestBody Map<String, String> json
    ) {
        List<Organization> organization = organizationRepo.findById(Long.parseLong(json.get("orgId")));
        Office office = new Office(Long.parseLong(json.get("id")),
                organization.get(0), json.get("name"),
                json.get("address"), json.get("phone"),
                json.get("isActive") != null && (json.get("isActive").equalsIgnoreCase("true")));
        officeRepo.save(office);

        return new ResultSuccess("success");
    }

    @GetMapping("office/save")
    public ResultSuccess saveOffice(
            @RequestParam(value = "orgId") Long orgId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "isActive", required = false) Boolean isActive
    ) {
        Optional<Organization> organization = organizationRepo.findById(orgId);
        Office office = new Office(organization.get(), name, address, phone, isActive);

        return new ResultSuccess("success");
    }

    @PostMapping("office/save")
    public ResultSuccess saveOfficePost(@RequestBody Map<String, String> json) {
        Long orgId = json.get("orgId") == null ? null : Long.parseLong(json.get("orgId"));
        String name = json.get("name");
        String address = json.get("address");
        String phone = json.get("phone");
        Boolean isActive = json.get("isActive") == null ? null : Boolean.parseBoolean(json.get("isActive"));

        return saveOffice(orgId, name, address, phone, isActive);
    }

    @GetMapping("user/update")
    public ResultSuccess updateUserGet(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "secondName", required = false) String secondName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam(value = "position") String positionName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "docName", required = false) String docName,
            @RequestParam(value = "docNumber", required = false) String docNumber,
            @RequestParam(value = "docDate", required = false) Long docDate,
            @RequestParam(value = "citizenshipCode", required = false) Long citizenshipCode,
            @RequestParam(value = "isIdentified", required = false) Boolean isIdentified
    ) {
        Users user = usersRepo.findById(id).get();
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setMiddleName(middleName);
        Position position = user.getPosition();
        position.setName(positionName);
        user.setPhone(phone);
        UserDoc userDoc = user.getUserDoc();
        Docs docs = userDoc.getDocs();
        docs.setName(docName);
        userDoc.setDocNumber(docNumber);
        userDoc.setDocDate(docDate);
        user.setCitizenshipCode(citizenshipCode);
        user.setIdentified(isIdentified);

        usersRepo.save(user);
        return new ResultSuccess("success");
    }

    @PostMapping("user/update")
    public ResultSuccess updateUserPost(@RequestBody Map<String, String> json) {
        Long id = json.get("id") == null ? null : Long.parseLong(json.get("id"));
        String firstName = json.get("firstName");
        String secondName = json.get("secondName");
        String middleName = json.get("middleName");
        String positionName = json.get("position");
        String phone = json.get("phone");
        String docName = json.get("docName");
        String docNumber = json.get("docNumber");
        Long docDate = json.get("docDate") == null ? null : Long.parseLong(json.get("docDate"));
        Long citizenshipCode = json.get("citizenshipCode") == null ? null : Long.parseLong(json.get("citizenshipCode"));
        Boolean isIdentified = json.get("isIdentified") == null ? null : Boolean.parseBoolean(json.get("isIdentified"));

        return updateUserGet(id, firstName, secondName, middleName, positionName, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }

    @GetMapping("user/save")
    public ResultSuccess saveUserGet(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "officeId") Long officeId,
            @RequestParam(value = "secondName", required = false) String secondName,
            @RequestParam(value = "middleName", required = false) String middleName,
            @RequestParam(value = "position") String positionName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "docName", required = false) String docName,
            @RequestParam(value = "docNumber", required = false) String docNumber,
            @RequestParam(value = "docDate", required = false) Long docDate,
            @RequestParam(value = "citizenshipCode", required = false) Long citizenshipCode,
            @RequestParam(value = "isIdentified", required = false) Boolean isIdentified
    ) {
        Users user = new Users(firstName, secondName, middleName, phone, citizenshipCode, isIdentified);
        Optional<Office> office = officeRepo.findById(officeId);
        user.setOffice(office.get());
        List<Position> positions = positionRepo.findByName(positionName);
        if (positions == null || positions.size() == 0) {
            Position position = new Position();
            position.setName(positionName);
            user.setPosition(position);
            positionRepo.save(position);
        } else {
            user.setPosition(positions.get(0));
        }
        List<Docs> docs = docsRepo.findByName(docName);
        Docs doc;
        if (docs == null || docs.size() == 0) {
            doc = new Docs();
            doc.setName(docName);
            docsRepo.save(doc);
            doc = docsRepo.findByName(docName).get(0);
        } else {
            doc = docs.get(0);
        }
        UserDoc userDoc = new UserDoc();
        userDoc.setDocs(doc);
        userDoc.setDocNumber(docNumber);
        userDoc.setDocDate(docDate);
        userDocRepo.save(userDoc);
        user.setUserDoc(userDoc);

        usersRepo.save(user);
        return new ResultSuccess("success");
    }

    @PostMapping("user/save")
    public ResultSuccess saveUserGet(
            @RequestBody Map<String, String> json
    ) {
        String firstName = json.get("firstName");
        Long officeId = json.get("officeId") == null ? null : Long.parseLong(json.get("officeId"));
        String secondName = json.get("secondName");
        String middleName = json.get("middleName");
        String positionName = json.get("position");
        String phone = json.get("phone");
        String docName = json.get("docName");
        String docNumber = json.get("docNumber");
        Long docDate = json.get("docDate") == null ? null : Long.parseLong(json.get("docDate"));
        Long citizenshipCode = json.get("citizenshipCode") == null ? null : Long.parseLong(json.get("citizenshipCode"));
        Boolean isIdentified = json.get("isIdentified") == null ? null : Boolean.parseBoolean(json.get("isIdentified"));

        return saveUserGet(firstName, officeId, secondName, middleName, positionName, phone, docName, docNumber, docDate, citizenshipCode, isIdentified);
    }
}
