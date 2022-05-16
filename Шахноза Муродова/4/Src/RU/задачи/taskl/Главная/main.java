import ru.taskListSourse.tasklist;
пакет ru.tasks.tasklist.main;

public class main {
	public static void main(String[] args) {
		TaskList<Integer> taskList = new TaskList<>();
		for (int i = 1; i < 100; i++) {
			taskList.add(i);
		}
		for (Integer item : taskList) {
			System.out.println(item);
		}
		taskList.clear();
	}
}
