# Git Workflow Guide for Colleagues

A step-by-step guide for cloning, branching, and contributing to the API Automation Training Framework repository.

## Table of Contents
1. [Cloning the Repository](#cloning-the-repository)
2. [Creating a Branch](#creating-a-branch)
3. [Making Changes](#making-changes)
4. [Committing Changes](#committing-changes)
5. [Pushing Your Branch](#pushing-your-branch)
6. [Creating a Pull Request](#creating-a-pull-request)
7. [Useful Git Commands Reference](#useful-git-commands-reference)

---

## Cloning the Repository

### Step 1: Open Terminal
Open your terminal (or Git Bash on Windows) and navigate to where you want to store the project.

```bash
cd /path/to/your/projects
```

### Step 2: Clone the Repository
```bash
git clone https://github.com/manuel-negrean/api-automation-training-framework.git
```

### Step 3: Navigate into the Project
```bash
cd api-automation-training-framework
```

### Step 4: Verify the Clone
```bash
git remote -v
```
You should see:
```
origin  https://github.com/manuel-negrean/api-automation-training-framework.git (fetch)
origin  https://github.com/manuel-negrean/api-automation-training-framework.git (push)
```

---

## Creating a Branch

### Step 5: Check the Current Branch
```bash
git branch
```
You should be on the `main` branch (indicated by `*`).

### Step 6: Update Your Local Main Branch
Always pull the latest changes before creating a new branch:
```bash
git pull origin main
```

### Step 7: Create a New Branch
Use a descriptive branch name. Follow this naming convention:
- `feature/description` - for new features
- `bugfix/description` - for bug fixes
- `test/description` - for test additions
- `docs/description` - for documentation updates

Examples:
```bash
# For a new test
git checkout -b test/pet-api-delete-tests

# For a bug fix
git checkout -b bugfix/fix-authentication-error

# For a new feature
git checkout -b feature/add-error-handling

# For documentation
git checkout -b docs/update-setup-guide

# Simple examples with your own branch names
git checkout -b test/myNewTests
git checkout -b feature/myNewFeature
git checkout -b bugfix/myBugFix
git checkout -b docs/myDocUpdate
```

### Step 8: Verify Your New Branch
```bash
git branch
```
You should see your new branch name with an asterisk (`*`) indicating it's active.

---

## Making Changes

### Step 9: Make Your Changes
Edit files, add new tests, update documentation, etc.

Example: Adding a new test file or modifying existing ones.

### Step 10: Check What Changed
```bash
# See modified files
git status

# See specific changes in files
git diff
```

---

## Committing Changes

### Step 11: Stage Your Changes
```bash
# Stage all changes
git add .

# Or stage specific files
git add src/test/java/tests/YourNewTest.java
```

### Step 12: Verify Staged Changes
```bash
git status
```
Files should be listed under "Changes to be committed" in green.

### Step 13: Commit Your Changes
Write clear, descriptive commit messages:
```bash
git commit -m "Add new GET endpoint tests for pet retrieval"
```

**Commit Message Best Practices:**
- Start with an action verb: Add, Fix, Update, Remove, Refactor
- Be specific about what changed
- Keep it under 50 characters (ideally)
- No period at the end

Good examples:
- ✅ `Add pet deletion endpoint tests`
- ✅ `Fix null pointer exception in TestDataFactory`
- ✅ `Update README with setup instructions`

Bad examples:
- ❌ `stuff` or `changes`
- ❌ `Fixed everything`
- ❌ `WIP` or `test123`

---

## Pushing Your Branch

### Step 14: Push Your Branch to GitHub
```bash
git push origin feature/your-feature-name
```

On first push, you'll see:
```
* [new branch]      feature/your-feature-name -> feature/your-feature-name
```

### Step 15: Verify Your Push
```bash
# See all branches (local and remote)
git branch -a
```

---

## Creating a Pull Request

### Step 16: Open GitHub
Go to https://github.com/manuel-negrean/api-automation-training-framework

You should see a notification about your recently pushed branch with a green **"Compare & pull request"** button.

### Step 17: Create the Pull Request
- Click **"Compare & pull request"**
- Fill in a clear title and description
- Review your changes
- Click **"Create pull request"**

**PR Description Template:**
```
## Description
Brief description of what this PR does.

## Changes Made
- Change 1
- Change 2
- Change 3

## Testing
How did you test these changes?

## Related Issues
(If applicable, reference any related issues)
```

### Step 18: Wait for Review
The repository maintainer will review your PR and either:
- Approve and merge it
- Request changes
- Close it with feedback

---

## Useful Git Commands Reference

### Branching
```bash
# Create and switch to a new branch
git checkout -b branch-name
git checkout -b myNewBranch
git checkout -b test/pet-crud-operations
git checkout -b feature/add-logging

# Switch to an existing branch
git checkout branch-name
git checkout main
git checkout test/myUnfinishedWork

# List all local branches
git branch

# List all remote branches
git branch -r

# List all branches (local and remote)
git branch -a

# Delete a local branch
git branch -d branch-name
git branch -d test/old-tests
git branch -d feature/completed-feature

# Delete a remote branch
git push origin --delete branch-name
git push origin --delete feature/old-feature

# Rename current branch
git branch -M new-name
git branch -M test/improved-pet-tests
```

### Committing
```bash
# See status of changes
git status

# See detailed changes
git diff

# Stage all changes
git add .

# Stage specific file
git add filename
git add src/test/java/tests/PetApiTests.java

# Unstage a file
git reset filename
git reset src/main/java/utils/TestDataFactory.java

# Commit with message
git commit -m "Your message"
git commit -m "Add pet creation test"
git commit -m "Fix authentication header in BaseConfig"

# Amend the last commit
git commit --amend --no-edit

# See commit history
git log

# See simplified commit history
git log --oneline
git log --oneline -5
```

### Syncing
```bash
# Fetch changes from remote (without merging)
git fetch origin

# Pull changes from remote branch
git pull origin main
git pull origin test/pet-api-tests

# Push your branch to remote
git push origin branch-name
git push origin test/myNewTests
git push origin feature/new-feature

# Push all branches
git push origin --all

# Set upstream and push in one command
git push -u origin test/myBranch
```

### Undoing Changes
```bash
# Discard changes in a file (before staging)
git checkout -- filename
git checkout -- src/test/java/tests/PetApiTests.java

# Unstage a file
git reset filename
git reset src/main/java/config/BaseConfig.java

# Undo last commit (keep changes)
git reset --soft HEAD~1

# Undo last commit (discard changes)
git reset --hard HEAD~1

# Discard all local changes
git reset --hard
```

---

## Common Workflow Example

Here's a complete example from start to finish:

```bash
# 1. Clone the repository
git clone https://github.com/manuel-negrean/api-automation-training-framework.git
cd api-automation-training-framework

# 2. Update main branch
git pull origin main

# 3. Create a new branch
git checkout -b test/new-pet-tests

# 4. Make your changes (edit files)
# ... add your test file or modify existing ones ...

# 5. Check your changes
git status
git diff

# 6. Stage your changes
git add .

# 7. Commit your changes
git commit -m "Add comprehensive pet creation and validation tests"

# 8. Push to GitHub
git push origin test/new-pet-tests

# 9. Go to GitHub and create a Pull Request
# Visit: https://github.com/manuel-negrean/api-automation-training-framework
```

---

## Tips & Best Practices

✅ **DO:**
- Pull from main before creating a new branch
- Use descriptive branch names
- Write clear commit messages
- Make small, focused commits
- Push regularly so you don't lose work
- Review your own changes before committing

❌ **DON'T:**
- Commit directly to `main` branch
- Mix unrelated changes in one commit
- Use vague commit messages like "Update" or "Fix"
- Leave uncommitted changes for too long
- Force push unless you really know what you're doing

---

## Need Help?

If something goes wrong:

```bash
# See your recent commits
git log --oneline -5

# See what changed in a specific commit
git show commit-hash

# See the difference between branches
git diff main..your-branch

# Ask for help (check Git documentation)
git help command-name
```

**For questions or issues, check GitHub documentation:**
https://docs.github.com/en/get-started

---

## Next Steps

1. Clone the repository
2. Create your feature branch
3. Make your changes
4. Commit and push
5. Create a Pull Request
6. Wait for review and merge

Happy coding! 🚀

---

## Quick Reference - Copy & Paste Examples

### Complete Branch Workflow
```bash
# Step 1: Create and switch to new branch
git checkout -b test/my-pet-tests

# Step 2: Make changes in your files...

# Step 3: Check what changed
git status

# Step 4: Stage and commit
git add .
git commit -m "Add comprehensive pet validation tests"

# Step 5: Push to GitHub
git push origin test/my-pet-tests

# Step 6: Go to GitHub and create a Pull Request
```

### More Real-World Examples
```bash
# Create a branch for fixing a bug
git checkout -b bugfix/fix-null-pointer-exception
git add .
git commit -m "Fix null pointer exception in TestDataFactory"
git push origin bugfix/fix-null-pointer-exception

# Create a branch for adding documentation
git checkout -b docs/add-installation-guide
git add docs/INSTALLATION.md
git commit -m "Add installation guide for local setup"
git push origin docs/add-installation-guide

# Create a branch for a new feature
git checkout -b feature/add-retry-mechanism
git add src/main/java/utils/RetryHandler.java
git commit -m "Add retry mechanism for flaky network requests"
git push origin feature/add-retry-mechanism

# Switch between branches
git checkout main
git checkout test/my-pet-tests
git checkout feature/add-retry-mechanism

# Delete a finished branch locally
git branch -d test/completed-tests

# Delete a finished branch on GitHub
git push origin --delete feature/old-feature
```

