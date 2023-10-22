class Person:
    """
    Class to represent a person with an ID and salary.
    """

    def __init__(self, id, salary):
        """
        Initialize a Person object.

        :param id: Person's ID.
        :param salary: Person's salary.
        """
        self.id = id
        self.salary = salary
        self.some_big_object = object()

    def get_salary(self):
        """
        Get the salary of the person.

        :return: Person's salary.
        """
        return self.salary

    def __str__(self):
        """
        Convert the object to a string for printing.

        :return: String representation of the Person.
        """
        return f"Person{{id={self.id}, salary={self.salary}, some_big_object={self.some_big_object}}}"


def tag_sort(person_objects, tag):
    """
    Sort the tag array based on the salary of the Person objects.

    :param person_objects: List of Person objects.
    :param tag: Tag array to be sorted.
    """
    n = len(person_objects)
    for i in range(n):
        for j in range(i + 1, n):
            if person_objects[tag[i]].get_salary() > person_objects[
                    tag[j]].get_salary():
                tag[i], tag[j] = tag[j], tag[i]


def main():
    n = 5
    person_objects = [
        Person(0, 233.5),
        Person(1, 23),
        Person(2, 13.98),
        Person(3, 143.2),
        Person(4, 3)
    ]
    tag = [i for i in range(n)]

    # Print original order
    print("Given Person and Tag")
    for i in range(n):
        print(f"{person_objects[i]} : Tag: {tag[i]}")

    # Sort the tag array
    tag_sort(person_objects, tag)

    # Print the sorted order
    print("New Tag Array after getting sorted as per Person[]")
    for i in range(n):
        print(tag[i])

    # Access persons in sorted order by salary
    for i in range(n):
        print(person_objects[tag[i]])


if __name__ == '__main__':
    main()
