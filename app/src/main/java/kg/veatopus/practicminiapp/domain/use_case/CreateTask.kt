package kg.veatopus.practicminiapp.domain.use_case

import kg.veatopus.practicminiapp.domain.TaskRepository
import kg.veatopus.practicminiapp.domain.model.Task

class CreateTask(
	private val repository: TaskRepository
) {
	
	suspend fun execute(task: Task) {
		repository.createTask(task)
		// handle some user-flow
	}
	
}