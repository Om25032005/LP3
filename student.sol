// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    // Structure for Student
    struct Student {
        uint256 rollNo;
        string name;
        uint256 age;
    }

    // Array to store multiple students
    Student[] public students;

    // Event for logging
    event StudentAdded(uint256 rollNo, string name, uint256 age);

    // Function to add new student
    function addStudent(uint256 _rollNo, string memory _name, uint256 _age) public {
        students.push(Student(_rollNo, _name, _age));
        emit StudentAdded(_rollNo, _name, _age);
    }

    // Function to get student details by index
    function getStudent(uint256 index) public view returns (uint256, string memory, uint256) {
        require(index < students.length, "Invalid index");
        Student memory s = students[index];
        return (s.rollNo, s.name, s.age);
    }  

    // Fallback function (called when no function matches or plain Ether is sent)
    fallback() external payable {
        // Accept Ether but do nothing
    }

    // Receive function to accept Ether directly
    receive() external payable {}
}
