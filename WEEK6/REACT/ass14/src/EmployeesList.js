import EmployeeCard from './EmployeeCard';

function EmployeesList(props) {

    return (

        <div>

            <h1>Employees List</h1>

            {

                props.employees.map((employee) => (

                    <EmployeeCard

                        key={employee.id}

                        employee={employee}

                    />

                ))

            }

        </div>

    );

}

export default EmployeesList;