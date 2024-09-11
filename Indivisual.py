class Hostel:
    def __init__(self, capacity):
        self.capacity = capacity
        self.rooms = {}
        self.payments = {}

    def add_student(self, name, roll_no, room_no):
        if room_no not in self.rooms:
            self.rooms[room_no] = []
        if len(self.rooms[room_no]) < self.capacity:
            self.rooms[room_no].append((name, roll_no))
            print(f"{name} with roll no {roll_no} assigned to room {room_no}.")
        else:
            print(f"Room {room_no} is already full.")
            
    def remove_student(self, name, roll_no, room_no):
        if room_no not in self.rooms:
            print(f"Room {room_no} does not exist.")
        else:
            if (name, roll_no) in self.rooms[room_no]:
                self.rooms[room_no].remove((name, roll_no))
                print(f"{name} with roll no {roll_no} removed from room {room_no}.")
            else:
                print(f"{name} with roll no {roll_no} is not in room {room_no}.")
        
    def make_payment(self, roll_no, amount):
        if roll_no in self.payments:
            self.payments[roll_no] += amount
        else:
            self.payments[roll_no] = amount
        print(f"Payment of {amount} made by roll no {roll_no}.")

    def check_capacity(self, room_no):
        if room_no in self.rooms:
            capacity_left = self.capacity - len(self.rooms[room_no])
            print(f"Room {room_no} has {capacity_left} seats available.")
        else:
            print(f"Room {room_no} is empty.")

    def display_students(self):
        print("Students in each room:")
        for room_no, students in self.rooms.items():
            print(f"Room {room_no}: {students}")

    def display_payments(self):
        print("Payments made by each student:")
        for roll_no, amount in self.payments.items():
            print(f"Roll no {roll_no}: Payment of {amount}")


def main():
    hostel = Hostel(capacity=4)  # Setting hostel capacity

    while True:
        print("\nHostel Management System Menu:")
        print("1. Add Student to Room")
        print("2. Make Payment")
        print("3. Check Room Capacity")
        print("4. Display Students in Rooms")
        print("5. Display Payments")
        print("6.Remove Student to Room")
        print("7. Exit")
        choice = input("Enter your choice: ")

        if choice == '1':
            name = input("Enter student name: ")
            roll_no = input("Enter student roll number: ")
            room_no = input("Enter room number: ")
            hostel.add_student(name, roll_no, room_no)
        elif choice == '2':
            roll_no = input("Enter student roll number: ")
            amount = float(input("Enter payment amount: "))
            hostel.make_payment(roll_no, amount)
        elif choice == '3':
            room_no = input("Enter room number: ")
            hostel.check_capacity(room_no)
        elif choice == '4':
            hostel.display_students()
        elif choice == '5':
            hostel.display_payments()
        elif choice =='6':
            name = input("Enter student name: ")
            roll_no = input("Enter student roll number: ")
            room_no = input("Enter room number: ")
            hostel.remove_student(name,roll_no,room_no)
        elif choice == '7':
            print("Exiting...")
            break
        else:
            print("Invalid choice. Please enter a valid option.")


if __name__ == "__main__":
    main()