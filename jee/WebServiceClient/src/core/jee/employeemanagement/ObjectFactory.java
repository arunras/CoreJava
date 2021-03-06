
package core.jee.employeemanagement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the core.jee.employeemanagement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllEmployees_QNAME = new QName("http://employeemanagement.jee.core/", "getAllEmployees");
    private final static QName _GetAllEmployeesResponse_QNAME = new QName("http://employeemanagement.jee.core/", "getAllEmployeesResponse");
    private final static QName _GetEmployeeById_QNAME = new QName("http://employeemanagement.jee.core/", "getEmployeeById");
    private final static QName _GetEmployeeByIdResponse_QNAME = new QName("http://employeemanagement.jee.core/", "getEmployeeByIdResponse");
    private final static QName _RegisterNewEmployee_QNAME = new QName("http://employeemanagement.jee.core/", "registerNewEmployee");
    private final static QName _RegisterNewEmployeeResponse_QNAME = new QName("http://employeemanagement.jee.core/", "registerNewEmployeeResponse");
    private final static QName _ServiceUnavailableException_QNAME = new QName("http://employeemanagement.jee.core/", "ServiceUnavailableException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: core.jee.employeemanagement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllEmployees }
     * 
     */
    public GetAllEmployees createGetAllEmployees() {
        return new GetAllEmployees();
    }

    /**
     * Create an instance of {@link GetAllEmployeesResponse }
     * 
     */
    public GetAllEmployeesResponse createGetAllEmployeesResponse() {
        return new GetAllEmployeesResponse();
    }

    /**
     * Create an instance of {@link GetEmployeeById }
     * 
     */
    public GetEmployeeById createGetEmployeeById() {
        return new GetEmployeeById();
    }

    /**
     * Create an instance of {@link GetEmployeeByIdResponse }
     * 
     */
    public GetEmployeeByIdResponse createGetEmployeeByIdResponse() {
        return new GetEmployeeByIdResponse();
    }

    /**
     * Create an instance of {@link RegisterNewEmployee }
     * 
     */
    public RegisterNewEmployee createRegisterNewEmployee() {
        return new RegisterNewEmployee();
    }

    /**
     * Create an instance of {@link RegisterNewEmployeeResponse }
     * 
     */
    public RegisterNewEmployeeResponse createRegisterNewEmployeeResponse() {
        return new RegisterNewEmployeeResponse();
    }

    /**
     * Create an instance of {@link ServiceUnavailableException }
     * 
     */
    public ServiceUnavailableException createServiceUnavailableException() {
        return new ServiceUnavailableException();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployees }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "getAllEmployees")
    public JAXBElement<GetAllEmployees> createGetAllEmployees(GetAllEmployees value) {
        return new JAXBElement<GetAllEmployees>(_GetAllEmployees_QNAME, GetAllEmployees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllEmployeesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "getAllEmployeesResponse")
    public JAXBElement<GetAllEmployeesResponse> createGetAllEmployeesResponse(GetAllEmployeesResponse value) {
        return new JAXBElement<GetAllEmployeesResponse>(_GetAllEmployeesResponse_QNAME, GetAllEmployeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeById }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "getEmployeeById")
    public JAXBElement<GetEmployeeById> createGetEmployeeById(GetEmployeeById value) {
        return new JAXBElement<GetEmployeeById>(_GetEmployeeById_QNAME, GetEmployeeById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "getEmployeeByIdResponse")
    public JAXBElement<GetEmployeeByIdResponse> createGetEmployeeByIdResponse(GetEmployeeByIdResponse value) {
        return new JAXBElement<GetEmployeeByIdResponse>(_GetEmployeeByIdResponse_QNAME, GetEmployeeByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNewEmployee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterNewEmployee }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "registerNewEmployee")
    public JAXBElement<RegisterNewEmployee> createRegisterNewEmployee(RegisterNewEmployee value) {
        return new JAXBElement<RegisterNewEmployee>(_RegisterNewEmployee_QNAME, RegisterNewEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterNewEmployeeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterNewEmployeeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "registerNewEmployeeResponse")
    public JAXBElement<RegisterNewEmployeeResponse> createRegisterNewEmployeeResponse(RegisterNewEmployeeResponse value) {
        return new JAXBElement<RegisterNewEmployeeResponse>(_RegisterNewEmployeeResponse_QNAME, RegisterNewEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceUnavailableException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceUnavailableException }{@code >}
     */
    @XmlElementDecl(namespace = "http://employeemanagement.jee.core/", name = "ServiceUnavailableException")
    public JAXBElement<ServiceUnavailableException> createServiceUnavailableException(ServiceUnavailableException value) {
        return new JAXBElement<ServiceUnavailableException>(_ServiceUnavailableException_QNAME, ServiceUnavailableException.class, null, value);
    }

}
