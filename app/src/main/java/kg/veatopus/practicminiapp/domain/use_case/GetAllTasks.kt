package kg.veatopus.practicminiapp.domain.use_case

import kg.veatopus.practicminiapp.domain.TaskRepository
import kg.veatopus.practicminiapp.domain.model.Task

class GetAllTasks(
	private val repository: TaskRepository
) {
	suspend fun execute(): List<Task> {
		// handle some user-flow
		return repository.getTasks()
	}
}